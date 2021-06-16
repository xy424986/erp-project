package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.util.StringUtil;
import com.hnguigu.mapper.SCellMapper;
import com.hnguigu.mapper.SGatherDetailsMapper;
import com.hnguigu.mapper.SGatherMapper;
import com.hnguigu.service.SGatherService;
import com.hnguigu.util.Scheduling;
import com.hnguigu.vo.SCell;
import com.hnguigu.vo.SGather;
import com.hnguigu.vo.SGatherDetails;
import com.hnguigu.vo.extend.SGatherEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SGatherServiceImpl extends ServiceImpl<SGatherMapper, SGather> implements SGatherService {

    @Autowired
    SGatherMapper sGatherMapper;
    @Autowired
    SGatherDetailsMapper sGatherDetailsMapper;
    @Autowired
    SCellMapper sCellMapper;
    /**
     * 入库调度-总数据查询-xyb
     * @param pageNo
     * @param pageSize
     * @param sGather
     * @return
     */
    @Override
    public IPage<SGather> queryAllSGather(int pageNo, int pageSize, SGather sGather) {
       /* PageHelper.startPage(pageNo, pageSize);
        List<DFile> sGathers = sGatherMapper.querySGather();
        PageInfo<DFile> sCellPageInfo = new PageInfo<>(sGathers);*/
        QueryWrapper<SGather> sGatherQueryWrapper = new QueryWrapper<>();
        if (!StringUtil.isEmpty(sGather.getGatherId()))
        sGatherQueryWrapper.eq("GATHER_ID",sGather.getGatherId());

        return this.page(new Page<SGather>(pageNo,pageSize), sGatherQueryWrapper);
    }
    /**
     * 入库调度单-查询
     *
     * @param
     */
    @Override
    public SGatherEx queryByIdSGatherEx(String productId) {
        return sGatherMapper.queryByIdSGatherEx(productId);
    }

    /**
     * 入库调度-xyb
     * @param scheduling 入库调度特制beng
     * @return
     */
    @Override
    public String addSGather(Scheduling scheduling) {
        System.out.println("scheduling"+scheduling);
        SGather sGather = new SGather();
        // 本次入库数量=应入库数
        // b)本次入库数量如果不等于应入库数
        QueryWrapper<SGatherDetails> sGatherDetailsQueryWrapper = new QueryWrapper<>();
        sGatherDetailsQueryWrapper.eq("PRODUCT_ID",scheduling.getProductId());
        SGatherDetails sGatherDetails = sGatherDetailsMapper.selectOne(sGatherDetailsQueryWrapper);
        if (sGatherDetails.getAmount().equals(scheduling.getAmount())){
            // 本次入库数量<=最大存储量—当前存储量
            QueryWrapper<SCell> sCellQueryWrapper = new QueryWrapper<>();
            sCellQueryWrapper.eq("PRODUCT_ID",scheduling.getProductId());
            SCell sCell = sCellMapper.selectOne(sCellQueryWrapper);
            int sCellAmount=sCell.getMaxCapacityAmount()-sCell.getAmount();
            if(sCellAmount<scheduling.getAmount()){
                System.out.println(sCellAmount+"本次入库数量过大,仓库储存不足"+scheduling.getAmount());
                return "本次入库数量过大,仓库储存不足";
            }
            // 保存时：
            // a)当前存储量=当前存储量+本次入库数量
            int sCellAmount2=sCell.getAmount()+scheduling.getAmount();
            sCell.setAmount(sCellAmount2);//当前储存
            sCellMapper.updateById(sCell);//添加当前储存
            sGatherDetails.setGatherTag("K002-2");//明细-已调度
            sGatherDetailsMapper.updateById(sGatherDetails);//修改入库标志
            sGather.setGatherTag("K002-2");//已调度
            sGather.setAttemper(scheduling.getAttemper());//调度人
            sGather.setAttemperTime(scheduling.getAttemperTime());//调度时间;

/*            QueryWrapper<SGather> sGatherQueryWrapper = new QueryWrapper<>();
            sGatherQueryWrapper.eq("GATHER_ID",scheduling.getGatherId());
            boolean save = this.update(sGatherQueryWrapper);*/
            UpdateWrapper<SGather> sGatherUpdateWrapper = new UpdateWrapper<>();
            sGatherUpdateWrapper.eq("GATHER_ID",scheduling.getGatherId());
            boolean save = this.update(sGather,sGatherUpdateWrapper);
            if (save)
                return "入库成功!";
        }else {
            System.out.println(sGatherDetails.getAmount()+"本次入库数量应该与应入库数量一致!"+scheduling.getAmount());
            return "本次入库数量应该与应入库数量一致!";
        }
        return "入库失败!";
    }
}
