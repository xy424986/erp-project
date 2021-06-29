package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.MApplyMapper;
import com.hnguigu.service.MApplyService;
import com.hnguigu.util.IdUtil;
import com.hnguigu.vo.MApply;
import org.springframework.beans.factory.annotation.Autowired;
import com.hnguigu.vo.SCell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MApplyServiceImpl extends ServiceImpl<MApplyMapper, MApply> implements MApplyService {
    @Autowired
    MApplyMapper mApplyMapper;
    /**
     * 制定生产派工单：根据产品编号查询生产计划数据
     * @param productId
     * @return
     */
    @Override
    public MApply queryByproductId(String productId) {
        return mApplyMapper.queryByproductId(productId);
    }

    /**
     *hhy
     * @param pageno
     * @param pagesize
     * @param mApply
     * @return
     */
    @Override
    public IPage<MApply> queryAll(int pageno, int pagesize, MApply mApply) {
        QueryWrapper<MApply> queryWrapper = new QueryWrapper<MApply>();
        queryWrapper.groupBy("APPLY_ID");


        return this.page(new Page<MApply>(pageno, pagesize), queryWrapper);
    }

    /**
     * hhy
     * 根据id查询当行数据
     *
     * @param mApply
     * @return
     */
    @Override
    public List<MApply> queryById(MApply mApply) {
        QueryWrapper<MApply> queryWrapper = new QueryWrapper<MApply>();
        queryWrapper.eq("APPLY_ID", mApply.getApplyId());
        return mApplyMapper.selectList(queryWrapper);
    }

    /**
     * hhy
     * 根据编号修改状态
     * @param mApply
     * @return
     */
    @Override
    public int updateStateById(MApply mApply) {

        UpdateWrapper<MApply> updateWrapper = new UpdateWrapper<MApply>();
        updateWrapper.eq("APPLY_ID", mApply.getApplyId());
        mApply.setRegisterTime(new Date());
        return mApplyMapper.update(mApply ,updateWrapper);
    }

    /**
     * hyy
     * 审核
     * 查询对应状态的所有数据
     *
     * @param mApply
     * @return
     */
    @Override
    public List<MApply> queryByState(MApply mApply) {
        QueryWrapper<MApply> queryWrapper = new QueryWrapper<MApply>();
        queryWrapper.eq("CHECK_TAG", mApply.getCheckTag());
        queryWrapper.groupBy("APPLY_ID");
        return mApplyMapper.selectList(queryWrapper);
    }

    @Override
    public int insert(List<MApply> mApplyList) {
        IdUtil idUtil = new IdUtil();
        String applyId = "";
        List<MApply> list = this.list();
        if (list.size() != 0) {
            MApply mApply = list.get(list.size() - 1);
            applyId = idUtil.ApplyId(mApply);
        } else {
            //获取当前时间
            Date dt = new Date();
            SimpleDateFormat matter1 = new SimpleDateFormat("yyyyMMdd");
            String date = matter1.format(dt);
            applyId = "300" + date + "00001";
            System.out.println(applyId);
        }
        int row = 0;

        for (MApply mApply : mApplyList) {
            mApply.setApplyId(applyId);
            mApply.setProductId(mApply.getProductId());
            mApply.setProductName(mApply.getProductName());
            mApply.setProductDescribe(mApply.getProductDescribe());
            mApply.setType(mApply.getType());
            mApply.setAmount(mApply.getAmount());
            mApply.setRegisterTime(new Date());
            mApply.setRemark(mApply.getRemark());
            mApply.setRegister(mApply.getRegister());
            mApply.setCheckTag("S001-0");
            mApply.setManufactureTag("P001-0");
            row = mApplyMapper.insert(mApply);
        }
        return row;
    }
}
