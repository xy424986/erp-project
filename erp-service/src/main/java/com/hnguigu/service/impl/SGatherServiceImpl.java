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

import java.util.List;

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
        if (!StringUtil.isEmpty(sGather.getGatherId())) {
            sGatherQueryWrapper.eq("GATHER_ID", sGather.getGatherId());
        }
        IPage<SGather> page = this.page(new Page<SGather>(pageNo, pageSize), sGatherQueryWrapper);
        System.out.println("queryAllSGather:"+page);
        return page;
    }
    /**
     * 入库调度单-查询-xyb
     *
     * @param
     * @param id
     */
    @Override
    public SGatherEx queryByIdSGatherEx(int id) {
        return sGatherMapper.queryByIdSGatherEx(id);
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

            sGatherDetails.setGatherTag("K002-2");//明细-已调度
            sGatherDetails.setAss(scheduling.getAss());//储存地址集合
            sGatherDetails.setGatheredAmount(scheduling.getAmount());//确认入库数量
            //连接查询
            List<SGatherDetails> sGatherDetails1 = sGatherDetailsMapper.queryByParentIdSGatherDetails1(scheduling.getScellformId());
            //判断明细表里的入库标志为K002-1字段是否只有一条
            //只有一条就证明:这条明细记录入库标志为K002-1
            //修改完这条就没有不调用的明细记录,可进入if判断修改入库表库存标志为K002-2(以调用)
            System.out.println("addSGather中的sGatherDetails1.getProductId:"+scheduling.getProductId());
            System.out.println("addSGather中的sGatherDetails1.size:"+sGatherDetails1.size());
            if (sGatherDetails1.size() ==1){
                System.out.println("进入if方法");
                sGather.setGatherTag("K002-2");//已调度
            }

            sGather.setAttemper(scheduling.getAttemper());//调度人
            sGather.setAttemperTime(scheduling.getAttemperTime());//调度时间;

            UpdateWrapper<SGather> sGatherUpdateWrapper = new UpdateWrapper<>();
            sGatherUpdateWrapper.eq("GATHER_ID",scheduling.getGatherId());

            sCellMapper.updateById(sCell);//添加当前储存
            sGatherDetailsMapper.updateById(sGatherDetails);//修改入库标志
            boolean save = this.update(sGather,sGatherUpdateWrapper);
            if (save)
                return "入库成功!";
        }else {
            System.out.println(sGatherDetails.getAmount()+"本次入库数量应该与应入库数量一致!"+scheduling.getAmount());
            return "本次入库数量应该与应入库数量一致!";
        }
        return "入库失败!";
    }

    /**
     * 入库调度单总调度-xyb
     * @param gatherId 入库编号
     * @return
     */
    @Override
    public SGather queryByGatherIdSGather(String gatherId) {
        QueryWrapper<SGather> sGatherQueryWrapper = new QueryWrapper<>();
        sGatherQueryWrapper.eq("GATHER_ID",gatherId);
        return this.getOne(sGatherQueryWrapper);
    }
    /**
     * 入库-复核-xyb
     * @param sGather
     * @return
     */
    @Override
    public boolean amendSGather(SGather sGather) {
        sGather.setCheckTag("S001-1");
        return this.updateById(sGather);
    }
}
