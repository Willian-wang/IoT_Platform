package com.heiyu.platform.device.entity.common;

/**
 * @ClassName GenericResponse
 * @Description 综合返回类，包含返回状态码，返回信息。其他所有返回类都将继承该类。
 * @Author Jayfeather
 * @Date 2019/5/13 15:54
 * @Version 1.0
 **/
public class  BasicResponseVO<T> {

    private int code=200;

    private String message="OK";

    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BasicResponseVO(T data){
        this.data =data;
    }

    public BasicResponseVO(){}
}
