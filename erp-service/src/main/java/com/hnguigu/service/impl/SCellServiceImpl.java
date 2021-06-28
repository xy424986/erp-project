package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hnguigu.mapper.SCellMapper;
import com.hnguigu.service.SCellService;
import com.hnguigu.util.IdUtil;
import com.hnguigu.vo.DFile;
import com.hnguigu.vo.SCell;
import com.hnguigu.vo.extend.SCellEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SCellServiceImpl extends ServiceImpl<SCellMapper, SCell> implements SCellService {

    @Autowired
    SCellMapper sCellMapper;

    /**
     * 制作安全库存配置单-添加-xyb
     * @param sCell
     * @return
     */
    @Override
    public boolean addSCll(SCell sCell) {
        IdUtil idUtil = new IdUtil();
        System.out.println(sCell);
        List<SCell> list = this.list();
        if (list.size()!=0) {
            SCell sCell1 = list.get(list.size() - 1);
            sCell.setStoreId(sCell1.getStoreId());
            String cellId = idUtil.CellId(sCell);
            sCell.setStoreId(cellId);
            System.out.println(cellId);
        }else {
            //获取当前时间
            Date dt=new Date();
            SimpleDateFormat matter1=new SimpleDateFormat("yyyyMMdd");
            String date = matter1.format(dt);
            sCell.setStoreId("400"+date+"00001");
            System.out.println("400"+date+"00001");
        }
        sCell.setCheckTag("S001-0");
        return this.save(sCell);
    }
    /**
     * 安全库存配置单-复核-总数据查询-xyb
     * @return
     */
    public PageInfo<SCellEx> queryAllSCll(int pageNo, int pageSize, DFile dFile, String tag, String tag2){
        System.out.println("queryAllSCll"+tag+":"+tag2);
           // 设置分页参数
        PageHelper.startPage(pageNo, pageSize);
        List<SCellEx> sCells = sCellMapper.queryAllSCll(tag,tag2);
        // 封装分页对象
        PageInfo<SCellEx> sCellPageInfo = new PageInfo<SCellEx>(sCells);
        return sCellPageInfo;
    }
    /**
     *查询安全库存配置单-复核的数据-xyb
     * @param productId
     * @param session
     * @return
     */
    @Override
    public SCell queryByIdSCell(String productId, HttpSession session) {
        System.out.println("queryByIdSCell的productId"+productId);
        QueryWrapper<SCell> queryWrapper = new QueryWrapper<SCell>();
        queryWrapper.eq("STORE_ID",productId);
        return this.getOne(queryWrapper);
    }
    /**
     *查询安全库存配置单中的-复核表格数据-xyb
     * @param productId
     * @return
     */
    @Override
    public List<SCell> queryByIdSCell2(String productId) {
        System.out.println("queryByIdSCell2的productId"+productId);
        QueryWrapper<SCell> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("PRODUCT_ID",productId);
        return  this.list(queryWrapper);
    }
    /**
     * 制作安全库存配置单-复核-xyb
     * @param id,CheckTag
     * @param sCell
     * @return
     */
    @Override
    public boolean amendCheckTag(int id, SCell sCell) {
        sCell.setCheckTag("S001-1");
        return this.updateById(sCell);
    }
    /**
     * 制作安全库存配置单-修改-xyb
     * @param sCell
     * @return
     */
    @Override
    public boolean amendSCll(SCell sCell) {
        System.out.println(sCell);
        sCell.setCheckTag("S001-2");
        return this.updateById(sCell);
    }

    @Override
    public PageInfo<SCellEx> queryAllSCll2(int pageno, int pagesize, DFile dFile, String s, String s1) {
        System.out.println("queryAllSCll"+s+":"+s1);
        // 设置分页参数
        PageHelper.startPage(pageno,pagesize);
        List<SCellEx> sCells = sCellMapper.queryAllSCll2(s,s1);
        // 封装分页对象
        PageInfo<SCellEx> sCellPageInfo = new PageInfo<SCellEx>(sCells);
        return sCellPageInfo;
    }


}
