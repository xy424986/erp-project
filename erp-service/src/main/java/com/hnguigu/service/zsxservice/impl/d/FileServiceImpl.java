package com.hnguigu.service.zsxservice.impl.d;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.vo.zsxvo.dao.QueryCondition;
import com.hnguigu.mapper.d.FileMapper;
import com.hnguigu.vo.zsxvo.pojo.d.File;
import com.hnguigu.service.zsxservice.d.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class FileServiceImpl  extends ServiceImpl<FileMapper, File> implements FileService {

    @Autowired
    FileMapper fileMapper;


    @Override
    public IPage<File> queryDelete(int pageno, int pagesize,QueryCondition queryCondition) {
        QueryWrapper<File> fileQueryWrapper = queryWrapper(queryCondition,"register_time");
        //产品删除标志 已删除 1
        fileQueryWrapper.eq("delete_tag",1);
        return this.page(new Page<File>(pageno,pagesize),fileQueryWrapper);
    }


    @Override
    public IPage<File> queryNoShenghe(int pageno, int pagesize,QueryCondition queryCondition) {
        QueryWrapper<File> fileQueryWrapper = queryWrapper(queryCondition,"register_time");
        //产品删除标志 待审核 0
        fileQueryWrapper.eq("check_tag",0);
        return this.page(new Page<File>(pageno,pagesize),fileQueryWrapper);
    }

    /**
     * 查询需要组装的产品档案
     * @param pageno
     * @param pagesize
     * @param queryCondition
     * @return
     */
    @Override
    public IPage<File> queryFlieZuZuang(int pageno, int pagesize,QueryCondition queryCondition) {
        QueryWrapper<File> fileQueryWrapper = queryWrapper(queryCondition,"register_time");
        //审核标志 为通过 1
        fileQueryWrapper.eq("check_tag", 1);
        //产品删除标志 未删除 0
        fileQueryWrapper.eq("delete_tag",0);
        //物料组成标志 未设计 0
        fileQueryWrapper.eq("design_module_tag",0);
        //工序组成标志 未设计 0
        fileQueryWrapper.eq("design_procedure_tag",0);

        return this.page(new Page<File>(pageno,pagesize),fileQueryWrapper);
    }

    /**
     * 查询需要生产计划工序的产品档案
     * @param pageno
     * @param pagesize
     * @param file
     * @return
     */
    @Override
    public IPage<File> queryFlieShengChanGongXu(int pageno, int pagesize, QueryCondition file)
    {   QueryWrapper<File> fileQueryWrapper = queryWrapper(file,"register_time");
         List<File> shengchangshow = fileMapper.Shengchangshow();
        return new Page<File>(pageno, pagesize).setRecords(shengchangshow);

    }

    @Override
    public IPage<File> queryGongXu(int pageno, int pagesize,QueryCondition file) {
        QueryWrapper<File> fileQueryWrapper = queryWrapper(file,"register_time");
        return this.page(new Page<File>(pageno,pagesize),fileQueryWrapper);
    }

    @Override
    public IPage<File> querykeSC(int pageno, int pagesize, QueryCondition file) {
          /*Page<File> fileIPage = new Page<>(pageno,pagesize);
        fileIPage.setRecords(new ArrayList<>());
        return fileIPage;*/
        QueryWrapper<File> fileQueryWrapper = queryWrapper(file,"register_time");
        //审核标志 为通过 1
        fileQueryWrapper.eq("check_tag", 1);
        //产品删除标志 未删除 0
        fileQueryWrapper.eq("delete_tag",0);
        //用途类型 - 商品
        fileQueryWrapper.eq("type",1);
        //物料组成标志 已设计 1
        fileQueryWrapper.eq("design_module_tag",1);
        //工序组成标志 未设计 1
        fileQueryWrapper.eq("design_procedure_tag",1);
        return this.page(new Page<File>(pageno,pagesize),fileQueryWrapper);

    }

    /**
     *
     * @param file
     * @return
     */
    public QueryWrapper<File> queryWrapper(QueryCondition file,String timeSting) {
        QueryWrapper<File> queryWrapper = new QueryWrapper<File>();
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
                queryWrapper.ge(timeSting,file.getStarttime());
                queryWrapper.le(timeSting,file.getStarttime());
            }
            //名字查询菜单
            if (file.getTjname() != null && !"".equals(file.getTjname())) {
                queryWrapper.like("product_name", file.getTjname());
            }
        }
        return queryWrapper;
    }
}
