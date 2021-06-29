package com.hnguigu.util;
import com.hnguigu.vo.*;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IdUtil {

    //产品编号
    public String ProductId(DFile dfile){
        String id = dfile.getProductId();
        int b = Integer.parseInt(id.substring(id.length() - 6));
        b++;
        DecimalFormat df=new DecimalFormat("000000");
        String str2=df.format(b);
        return str2;
    }

    //物料设计单编号
    public String ModuleId(DModule module){
        Date dt=new Date();
        SimpleDateFormat matter1=new SimpleDateFormat("yyyyMMdd");
        String date =  matter1.format(dt);

        String id=module.getDesignId();
        int b= Integer.parseInt(id.substring(id.length()-4));
        b++;
        DecimalFormat df=new DecimalFormat("0000");
        String str2=df.format(b);
        return "200"+date+str2;
    }

    //工序设计单编号
    public String DesignProcedureId(MDesignProcedure designProcedure){
        //获取当前时间
        Date dt=new Date();
        SimpleDateFormat matter1=new SimpleDateFormat("yyyyMMdd");
        String date =  matter1.format(dt);

        String id=designProcedure.getDesignId();
        int b= Integer.parseInt(id.substring(id.length()-4));
        b++;
        DecimalFormat df=new DecimalFormat("0000");
        String str2=df.format(b);
        return "201"+date+str2;
    }

    //生产计划编号
    public static String ApplyId(MApply apply){

        int b=0;
        String str2="0001";
        //获取当前时间
        Date dt=new Date();
        SimpleDateFormat matter1=new SimpleDateFormat("yyyyMMdd");
        String date =  matter1.format(dt);
        if(apply!=null){
            String id=apply.getApplyId();
            b= Integer.parseInt(id.substring(id.length()-4));
            b++;
            DecimalFormat df=new DecimalFormat("0000");
            str2=df.format(b);

        }
        return "300"+date+str2;
    }

    //派工单编号
    public String ManufactureId(MManuFacture manufacture){
        //获取当前时间
        Date dt=new Date();
        SimpleDateFormat matter1=new SimpleDateFormat("yyyyMMdd");
        String date =  matter1.format(dt);

        String id=manufacture.getManufactureId();
        int b= Integer.parseInt(id.substring(id.length()-4));
        b++;
        DecimalFormat df=new DecimalFormat("0000");
        String str2=df.format(b);
        return "301"+date+str2;
    }

    //库存编号
    public String CellId(SCell cell){
        //获取当前时间
        Date dt=new Date();
        SimpleDateFormat matter1=new SimpleDateFormat("yyyyMMdd");
        String date = matter1.format(dt);

        String id=cell.getStoreId();
        int b= Integer.parseInt(id.substring(id.length()-4));
        b++;
        DecimalFormat df=new DecimalFormat("0000");
        String str2=df.format(b);
        return "400"+date+str2;
    }

    //出库单编号
    public String PayId(SPay pay){
        //获取当前时间
        Date dt=new Date();
        SimpleDateFormat matter1=new SimpleDateFormat("yyyyMMdd");
        String date =  matter1.format(dt);

        String id=pay.getPayId();
        int b= Integer.parseInt(id.substring(id.length()-4));
        b++;
        DecimalFormat df=new DecimalFormat("0000");
        String str2=df.format(b);
        return "401"+date+str2;
    }

    //入库单编号
    public String GatherId(SGather gather){
        //获取当前时间
        Date dt=new Date();
        SimpleDateFormat matter1=new SimpleDateFormat("yyyyMMdd");
        String date =  matter1.format(dt);

        String id=gather.getGatherId();
        int b= Integer.parseInt(id.substring(id.length()-4));
        b++;
        DecimalFormat df=new DecimalFormat("0000");
        String str2=df.format(b);
        return "402"+date+str2;
    }

}
