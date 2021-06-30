package com.hnguigu.controller.zsxcontroller.m;

import com.hnguigu.vo.zsxvo.pojo.m.ProcedureModule;
import com.hnguigu.service.zsxservice.m.ProcedureModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("ProcedureModule")
public class ProcedureModuleController {
    @Autowired
    ProcedureModuleService procedureModuleService;


    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("SelectByParentId")
    public List<ProcedureModule> SelectByParentId(String id){
        return procedureModuleService.SelectByParentId(id);
    }

    /**
     *  生产登记-提交模态框的数据
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "Add",produces = "application/json;charset=utf-8")
    public boolean Add(@RequestBody List<ProcedureModule> gridData,String type){
        if(gridData.size()==0){
            return false;
        }
        return procedureModuleService.GongXuAdd(gridData);
    }

    /**
     *  生产登记-提交模态框的数据
     * @return
     */
    @ResponseBody
    @RequestMapping("JiaojieAdd")
    public boolean JiaojieAdd(Integer id,Integer shuliang){
        if(id==0){
            return false;
        }
        return procedureModuleService.JiaojieAdd(id,shuliang);
    }

    /**
     *  生产审核-提交模态框的数据
     * @return
     */
    @ResponseBody
    @RequestMapping( "Shenghe")
    public boolean Shenghe(Integer id ,boolean type){
        if (id==null){
            return false;
        }
        return procedureModuleService.Shenghe(id,type);
    }
    /**
     *  生产审核-提交模态框的数据
     * @return
     */
    @ResponseBody
    @RequestMapping( "ShengheJiaojie")
    public boolean ShengheJiaojie(Integer id ,boolean type){
        if (id==null){
            return false;
        }
        return procedureModuleService.ShengheJiaojie(id,type);
    }

}
