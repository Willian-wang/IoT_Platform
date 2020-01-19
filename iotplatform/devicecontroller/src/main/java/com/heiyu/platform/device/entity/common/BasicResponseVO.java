package com.heiyu.platform.device.entity.common;

import java.util.HashMap;

/**
 * 综合返回类，包含返回状态码，返回信息。其他所有返回类都将继承该类。
 * @author  Jayfeather
 * @date  2019/5/13 15:54
 * @version  1.0
 **/
public class  BasicResponseVO<T> {
    private int reponseCode;
    private String responseInf;
    private T data;

    public BasicResponseVO(T t){

        if(t instanceof String && t.equals("success")){
            setStatus(10000);
            this.data = null;
        }else{
            setStatus(10000);
            this.data = t;
        }
    }

    public int getReponseCode() {
        return reponseCode;
    }

    public void setReponseCode(int reponseCode) {
        this.reponseCode = reponseCode;
    }

    public String getResponseInf() {
        return responseInf;
    }

    public void setResponseInf(String responseInf) {
        this.responseInf = responseInf;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    static final HashMap<Integer,String> statusMap = new HashMap<>();
    {
        statusMap.put(10000,"OK");
        statusMap.put(20000,"Not authority");
        statusMap.put(30000,"Request is too quick");
        statusMap.put(40000,"Not found");
        statusMap.put(50000,"ServerError");
    }


    private void setStatus(int code){
        responseInf = statusMap.get(code);
        if(responseInf == null){
            throw new IllegalArgumentException("无此状态码");
        }else {
            reponseCode = code;
        }
    }


}
