package com.hnguigu.vo.zsxvo.pojo.util;

import lombok.Data;

@Data
public class ResultUtil<T> {

    private Boolean result;
    private String message;
    private T data;

}
