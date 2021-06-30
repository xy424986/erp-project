package com.hnguigu.controller.zsxcontroller.m;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hnguigu.vo.zsxvo.dao.QueryCondition;
import com.hnguigu.vo.zsxvo.pojo.m.Manufacture;
import com.hnguigu.service.zsxservice.m.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("Manufacture")
public class ManufactureController {

    @Autowired
    ManufactureService manufactureService;

    /**
     * 制定生产派工单-添加
     * @param manufactures
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "Add",produces = "application/json;charset=utf-8")
    public boolean Add(@RequestBody Manufacture manufactures){
        return manufactureService.Add(manufactures);
    }

    /**
     * 生产派工单审核-显示数据
     * @param pageno
     * @param pagesize
     * @param queryCondition
     * @return
     */
    @ResponseBody
    @RequestMapping("selectShengHeAll")
    public IPage<Manufacture> selectShengHeAll(@RequestParam(value = "pageno",defaultValue = "1") int pageno,
                                               @RequestParam(value = "pagesize",defaultValue = "10") int pagesize,
                                               QueryCondition queryCondition){
        return manufactureService.selectShengHeAll(pageno,pagesize,queryCondition);
    }

    /**
     * 生产派工单查询-显示数据
     * @param pageno
     * @param pagesize
     * @param queryCondition
     * @return
     */
    @ResponseBody
    @RequestMapping("selectAll")
    public IPage<Manufacture> selectAll(@RequestParam(value = "pageno",defaultValue = "1") int pageno,
                                               @RequestParam(value = "pagesize",defaultValue = "10") int pagesize,
                                               QueryCondition queryCondition){
        return manufactureService.selectAll(pageno,pagesize,queryCondition);
    }


    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("SelectId")
    public Manufacture SelectId(String id){
        return manufactureService.SelectId(id);
    }

    /**
     *  根据id查询
     * @param manufacture
     * @param type
     * @return
     */
    @ResponseBody
    @RequestMapping("UpdateByid")
    public boolean UpdateByid(Manufacture manufacture,boolean type){
        return manufactureService.UpdateByid(manufacture, type);
    }

    /**
     *  生产登记-显示数据
     * @param pageno
     * @param pagesize
     * @param queryCondition
     * @return
     */
    @ResponseBody
    @RequestMapping("selectDengJiAll")
    public IPage<Manufacture> selectDengJiAll(@RequestParam(value = "pageno",defaultValue = "1") int pageno,
                                        @RequestParam(value = "pagesize",defaultValue = "10") int pagesize,
                                        QueryCondition queryCondition){
        return manufactureService.selectDengJiAll(pageno,pagesize,queryCondition);
    }

    /**
     *  生产登记复核-显示数据
     * @param pageno
     * @param pagesize
     * @param queryCondition
     * @return
     */
    @ResponseBody
    @RequestMapping("selectSCSHAll")
    public IPage<Manufacture> selectSCSHAll(@RequestParam(value = "pageno",defaultValue = "1") int pageno,
                                               @RequestParam(value = "pagesize",defaultValue = "10") int pagesize,
                                               QueryCondition queryCondition){
        return manufactureService.selectSCSHAll(pageno,pagesize,queryCondition);
    }

    /**
     *  生产登记复核-显示数据
     * @param pageno
     * @param pagesize
     * @param queryCondition
     * @return
     */
    @ResponseBody
    @RequestMapping("selectSCAll")
    public IPage<Manufacture> selectSCAll(@RequestParam(value = "pageno",defaultValue = "1") int pageno,
                                            @RequestParam(value = "pagesize",defaultValue = "10") int pagesize,
                                            QueryCondition queryCondition){
        return manufactureService.selectSCAll(pageno,pagesize,queryCondition);
    }

}
