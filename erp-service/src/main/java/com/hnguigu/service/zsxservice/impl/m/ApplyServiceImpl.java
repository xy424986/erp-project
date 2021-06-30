package com.hnguigu.service.zsxservice.impl.m;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.vo.zsxvo.dao.QueryCondition;
import com.hnguigu.vo.zsxvo.dao.ShowId;
import com.hnguigu.mapper.m.ApplyMapper;
import com.hnguigu.vo.zsxvo.pojo.m.Apply;
import com.hnguigu.service.zsxservice.m.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApplyServiceImpl  extends ServiceImpl<ApplyMapper, Apply> implements ApplyService {

   @Autowired
    ApplyMapper applyMapper;


    @Override
    public boolean Add(List<Apply> applies) {
         ShowId showId = new ShowId();

         String s = showId.showShengChanId(applyMapper.showApplyId());
         Date date = new Date();
        for (Apply apply:applies){
            apply.setApplyId(s);
            apply.setChecker(null);
            apply.setCheckSuggestion(null);
            apply.setCheckTag("0");
            apply.setManufactureTag("0");
            apply.setId(null);
            apply.setRegisterTime(date);
        }
        return this.saveBatch(applies);
    }

    @Override
    public IPage<Apply> selectGroupApplyIdList(int pageno, int pagesize, QueryCondition queryCondition) {
        QueryWrapper<Apply> queryWrapper = queryWrapper(queryCondition);
        queryWrapper.groupBy("apply_id");
        return this.page(new Page<Apply>(pageno,pagesize),queryWrapper);
    }

    @Override
    public IPage<Apply> GroupApplyIdShenheAll(int pageno, int pagesize, QueryCondition queryCondition) {
        QueryWrapper<Apply> queryWrapper = queryWrapper(queryCondition);
        queryWrapper.eq("check_tag",0);
        queryWrapper.groupBy("apply_id");
        return this.page(new Page<Apply>(pageno,pagesize),queryWrapper);
    }

    @Override
    public List<Apply> selectByApplyId(String applyId) {
        QueryWrapper<Apply> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("apply_id",applyId);
        return this.list(queryWrapper);
    }

    @Override
    public boolean Shengheupdate(Apply apply, boolean type) {
         QueryWrapper<Apply> applyQueryWrapper = new QueryWrapper<>();
         applyQueryWrapper.eq("apply_id",apply.getApplyId());
         List<Apply> list = this.list(applyQueryWrapper);
         Date date = new Date();
        for(Apply app:list){
            if (type)
             app.setCheckTag("1");
            else
             app.setCheckTag("2");
             app.setChecker(apply.getChecker());
             app.setCheckSuggestion(apply.getCheckSuggestion());
             app.setCheckTime(date);
         }
        return this.updateBatchById(list);
    }

    @Override
    public IPage<Apply> ShenheChengGongAll(int pageno, int pagesize, QueryCondition manufactureName) {
        QueryWrapper<Apply> applyQueryWrapper = new QueryWrapper<>();
        applyQueryWrapper.eq("check_tag",1);
        applyQueryWrapper.eq("manufacture_tag",0);
        return this.page(new Page<Apply>(pageno,pagesize),applyQueryWrapper);
    }


    private QueryWrapper<Apply> queryWrapper(QueryCondition queryCondition){
        QueryWrapper<Apply> queryWrapper = new QueryWrapper<>();
        if (queryCondition != null) {
            //一级菜单
            if (queryCondition.getFirskindname() != null && !"".equals(queryCondition.getFirskindname())&& !"undefined".equals(queryCondition.getFirskindname())) {
                queryWrapper.like("first_kind_name", queryCondition.getFirskindname());
            }
            //二级菜单
            if (queryCondition.getSecondkindname() != null && !"".equals(queryCondition.getSecondkindname())&& !"undefined".equals(queryCondition.getSecondkindname())) {
                queryWrapper.like("second_kind_name", queryCondition.getSecondkindname());
            }
            //三级菜单
            if (queryCondition.getThirdkindname() != null && !"".equals(queryCondition.getThirdkindname())&& !"undefined".equals(queryCondition.getThirdkindname())) {
                queryWrapper.like("third_kind_name", queryCondition.getThirdkindname());
            }
            // 时间查询
            if (queryCondition.getStarttime()!=null&& queryCondition.getOvertime()!=null){
                queryWrapper.ge("register_time",queryCondition.getStarttime());
                queryWrapper.le("register_time",queryCondition.getStarttime());
            }
            //名字查询菜单
            if (queryCondition.getTjname() != null && !"".equals(queryCondition.getTjname())) {
                queryWrapper.like("product_name", queryCondition.getTjname());
            }
        }
        return queryWrapper;
    }
}
