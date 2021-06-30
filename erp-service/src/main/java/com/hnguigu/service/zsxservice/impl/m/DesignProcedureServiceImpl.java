package com.hnguigu.service.zsxservice.impl.m;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.vo.zsxvo.dao.QueryCondition;
import com.hnguigu.vo.zsxvo.dao.ShowId;
import com.hnguigu.mapper.d.FileMapper;
import com.hnguigu.mapper.m.DesignProcedureMapper;
import com.hnguigu.vo.zsxvo.pojo.d.File;
import com.hnguigu.vo.zsxvo.pojo.m.DesignProcedure;
import com.hnguigu.vo.zsxvo.pojo.m.DesignProcedureDetails;
import com.hnguigu.service.zsxservice.m.DesignProcedureDetailsService;
import com.hnguigu.service.zsxservice.m.DesignProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class DesignProcedureServiceImpl extends ServiceImpl<DesignProcedureMapper, DesignProcedure> implements DesignProcedureService {

    @Autowired
    FileMapper fileMapper;

    @Autowired
    DesignProcedureMapper designProcedureMapper;

   /* @Autowired
    DesignProcedureDetailsMapper designProcedureDetailsMapper;*/

    @Autowired
    DesignProcedureDetailsService designProcedureDetailsService;


    @Override
    public boolean DesignAdd(List<DesignProcedureDetails> designProcedure) {
        //改变档案状态
        DesignProcedureDetails designProcedureDetails = designProcedure.get(0);
        File file = fileMapper.selectById(designProcedureDetails.getParentId());

        BigDecimal sum = new BigDecimal("0");
        for (DesignProcedureDetails d: designProcedure) {
            d.setSubtotal(d.getLabourHourAmount().multiply(d.getCostPrice()));
            sum = sum.add(d.getSubtotal());
        }

        //制作工序表
        DesignProcedure de = new DesignProcedure();

        ShowId showId = new ShowId();
        String integer = showId.showGongXuId(designProcedureMapper.showProductId());
        de.setDesignId(integer);
        de.setFirstKindId(file.getFirstKindId());
        de.setFirstKindName(file.getFirstKindName());
        de.setSecondKindId(file.getSecondKindId());
        de.setSecondKindName(file.getSecondKindName());
        de.setThirdKindId(file.getThirdKindId());
        de.setThirdKindName(file.getThirdKindName());
        de.setProductId(file.getProductId());
        de.setProductName(file.getProductName());
        de.setProcedureDescribe(designProcedureDetails.getProcedureDescribe());
        de.setCostPriceSum(sum);
        de.setDesigner(designProcedureDetails.getRegister());
        de.setRegister(file.getRegister());
        de.setRegisterTime(new Date());
        int insert = designProcedureMapper.insert(de);
        if (insert==0){
            return false;
        }
       /*  String s = designProcedureDetailsMapper.showProductId();
        showId.showGongXuMingxiId(s);*/
        int bianhao= 1;
        for (DesignProcedureDetails d: designProcedure) {
            /*d.setProcedureName(designProcedureDetails.getProcedureName());*/
            d.setParentId(de.getId());
            d.setDetailsNumber(bianhao++);
            /*d.setProcedureId(de.getProductId());*/
            d.setProcedureDescribe(designProcedureDetails.getProcedureDescribe());
            d.setRegister(designProcedureDetails.getRegister());
            d.setRegisterTime(new Date());
        }
        boolean b = designProcedureDetailsService.saveBatch(designProcedure);
        if (!b){
            return false;
        }
        return true;
    }


    //工序物料设计单查询
    @Override
    public IPage<DesignProcedure> queryGongXuShenHe(int pageno, int pagesize, QueryCondition queryCondition) {
        QueryWrapper<DesignProcedure> procedureQueryWrapper = queryWrapper(queryCondition);
        procedureQueryWrapper.eq("check_tag",0);
        return this.page(new Page<DesignProcedure>(pageno,pagesize),procedureQueryWrapper);
    }

    @Override
    public IPage<DesignProcedure> queryGongXuAll(int pageno, int pagesize, QueryCondition queryCondition) {

        QueryWrapper<DesignProcedure> procedureQueryWrapper = queryWrapper(queryCondition);

        return this.page(new Page<DesignProcedure>(pageno,pagesize),procedureQueryWrapper);
    }

    //查询待成制定工序物料设计单
    @Override
    public IPage<DesignProcedure> queryGongXuShenHeCG(int pageno, int pagesize, QueryCondition queryCondition) {
        QueryWrapper<DesignProcedure> procedureQueryWrapper = queryWrapper(queryCondition);
        procedureQueryWrapper.eq("check_tag",1);
        procedureQueryWrapper.eq("design_module_tag",0);
        return this.page(new Page<DesignProcedure>(pageno,pagesize),procedureQueryWrapper);
    }

    @Override
    public DesignProcedure SelectByGongXuId(String id) {
         QueryWrapper<DesignProcedureDetails> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",id);
         DesignProcedure byId = this.getById(id);
         List<DesignProcedureDetails> list = designProcedureDetailsService.list(queryWrapper);
        byId.setDetailsList(list);
        return byId;
    }

    @Override
    public boolean GongXuShenHe(DesignProcedure designProcedure,boolean type) {

        DesignProcedure byId = designProcedureMapper.selectById(designProcedure.getId());
        byId.setChecker(designProcedure.getChecker());
        byId.setCheckSuggestion(designProcedure.getCheckSuggestion());
        byId.setCheckTime(new Date());
        byId.setChangeTag("0");
        if(type){
            byId.setCheckTag("1");
        }else {
            byId.setCheckTag("2");
        }
         int i = designProcedureMapper.updateById(byId);

        return i==0?false:true;
    }

    @Override
    public boolean DesignUpdate(List<DesignProcedureDetails> designProcedure) {

        DesignProcedureDetails designProcedureDetails = designProcedure.get(0);

        Integer parentId = designProcedureDetails.getParentId();
         String register = designProcedureDetails.getRegister();

        BigDecimal sum = new BigDecimal("0");
        for (DesignProcedureDetails d: designProcedure) {
            d.setSubtotal(d.getLabourHourAmount().multiply(d.getCostPrice()));
            sum = sum.add(d.getSubtotal());
        }

        Map<String,Object> map =new HashMap<>();
        map.put("parent_id",parentId);
        boolean b = designProcedureDetailsService.removeByMap(map);
        if(!b){
            return false;
        }

        DesignProcedure designProcedure1 = designProcedureMapper.selectById(parentId);
        designProcedure1.setCostPriceSum(sum);
        designProcedure1.setChanger(register);
        designProcedure1.setChangeTime(new Date());
        designProcedure1.setChangeTag("1");
        designProcedure1.setCheckTag("0");
        int i = designProcedureMapper.updateById(designProcedure1);
        if(i==0){
            return false;
        }

        int bianhao= 1;
        for (DesignProcedureDetails d: designProcedure) {
            /*d.setProcedureName(designProcedureDetails.getProcedureName());*/
            d.setParentId(parentId);
            d.setDetailsNumber(bianhao++);
            /*d.setProcedureId(de.getProductId());*/
            d.setProcedureDescribe(designProcedureDetails.getProcedureDescribe());
            d.setRegister(designProcedureDetails.getRegister());
            d.setRegisterTime(new Date());
        }
        boolean d = designProcedureDetailsService.saveBatch(designProcedure);
        if (!d){
            return false;
        }
        return true;
    }

    @Override
    public IPage<DesignProcedure> queryGongXuWuLiaoShenghe(int pageno, int pagesize, QueryCondition queryCondition) {
        QueryWrapper<DesignProcedure> procedureQueryWrapper = queryWrapper(queryCondition);
        procedureQueryWrapper.eq("check_tag",1);
        procedureQueryWrapper.eq("design_module_tag",1);
        return this.page(new Page<DesignProcedure>(pageno,pagesize),procedureQueryWrapper);

    }


    @Override
    public IPage<DesignProcedure> queryGongXuWuLiaoList(int pageno, int pagesize, QueryCondition queryCondition) {
        QueryWrapper<DesignProcedure> procedureQueryWrapper = queryWrapper(queryCondition);
        procedureQueryWrapper.eq("check_tag",1);
        return this.page(new Page<DesignProcedure>(pageno,pagesize),procedureQueryWrapper);

    }

    @Override
    public IPage<DesignProcedure> queryGongXuWuLiaoShow(int pageno, int pagesize, QueryCondition queryCondition) {
        QueryWrapper<DesignProcedure> procedureQueryWrapper = queryWrapper(queryCondition);
        //查询待审核中
        procedureQueryWrapper.eq("check_tag",1);
        procedureQueryWrapper.eq("design_module_tag",0);
        return this.page(new Page<DesignProcedure>(pageno,pagesize),procedureQueryWrapper);

    }

    @Override
    public boolean GongXuWuLiaoupdate(DesignProcedure designProcedure, boolean type) {
        DesignProcedure byId = designProcedureMapper.selectById(designProcedure.getId());
        byId.setChecker(designProcedure.getChecker());
        byId.setDesignModuleTag("2");
        if(type){
            byId.setDesignModuleTag("2");
        }else {
            byId.setDesignModuleTag("0");
        }
        byId.setDesignModuleChangeTag("0");
        int i = designProcedureMapper.updateById(byId);

        return i==0?false:true;
    }

    @Override
    public boolean GongXuWuLiaoZZ(String id) {
        DesignProcedure byId = this.getById(id);
        ;
        File file = fileMapper.selectProductId(byId.getProductId());
        file.setDesignProcedureTag("1");
        fileMapper.updateById(file);
        QueryWrapper<DesignProcedureDetails> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",id);
         List<DesignProcedureDetails> list = designProcedureDetailsService.list(queryWrapper);

        BigDecimal sum=new BigDecimal(0);
         for(DesignProcedureDetails details:list){
             sum=sum.add(details.getModuleSubtotal());
         }
        byId.setModuleCostPriceSum(sum);
        byId.setDesignModuleTag("1");
        return this.updateById(byId);
    }

    @Override
    public IPage<DesignProcedure> GongXuWuLiaoUpdateShow(int pageno, int pagesize, QueryCondition queryCondition) {
        QueryWrapper<DesignProcedure> procedureQueryWrapper = queryWrapper(queryCondition);
        procedureQueryWrapper.eq("check_tag",1);
        procedureQueryWrapper.ne("design_module_tag",0);
        procedureQueryWrapper.eq("design_module_change_tag",0);
        return this.page(new Page<DesignProcedure>(pageno,pagesize),procedureQueryWrapper);
    }

    @Override
    public boolean GXWLupdate(String id) {
        DesignProcedure byId = this.getById(id);
        QueryWrapper<DesignProcedureDetails> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",id);
        List<DesignProcedureDetails> list = designProcedureDetailsService.list(queryWrapper);

        BigDecimal sum=new BigDecimal(0);
        for(DesignProcedureDetails details:list){
            sum=sum.add(details.getModuleSubtotal());
            details.setDesignModuleChangeTag("0");
            designProcedureDetailsService.updateById(details);
        }

        byId.setModuleCostPriceSum(sum);
        byId.setDesignModuleTag("1");
        byId.setDesignModuleChangeTag("1");
        return this.updateById(byId);
    }


    @Override
    public DesignProcedure SelectByChanpingId(String id) {
         DesignProcedure designProcedure = designProcedureMapper.showbyParentId(id);
        QueryWrapper<DesignProcedureDetails> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",designProcedure.getId());
        List<DesignProcedureDetails> list = designProcedureDetailsService.list(queryWrapper);
        designProcedure.setDetailsList(list);
        return designProcedure;
    }

    /**
     * 条件查询封装
     * @param file
     * @return
     */
    public QueryWrapper<DesignProcedure> queryWrapper(QueryCondition file) {
        QueryWrapper<DesignProcedure> queryWrapper = new QueryWrapper<DesignProcedure>();
        if (file != null) {
            //一级菜单
            if (file.getFirskindname() != null && !"".equals(file.getFirskindname())&& !"undefined".equals(file.getFirskindname())) {
                queryWrapper.like("first_kind_name", file.getFirskindname());
            }
            //二级菜单
            if (file.getSecondkindname() != null && !"".equals(file.getSecondkindname())&& !"undefined".equals(file.getSecondkindname())) {
                queryWrapper.like("second_kind_name", file.getSecondkindname());
            }
            //三级菜单
            if (file.getThirdkindname() != null && !"".equals(file.getThirdkindname())&& !"undefined".equals(file.getThirdkindname())) {
                queryWrapper.like("third_kind_name", file.getThirdkindname());
            }
            // 时间查询
            if (file.getStarttime()!=null&& file.getOvertime()!=null){
                queryWrapper.ge("register_time",file.getStarttime());
                queryWrapper.le("register_time",file.getStarttime());
            }
            //名字查询菜单
            if (file.getTjname() != null && !"".equals(file.getTjname())) {
                queryWrapper.like("product_name", file.getTjname());
            }
        }
        return queryWrapper;
    }
}
