package com.shine.bean;


/**
 * 返回json数据
 * Created by hq on 2016/12/2.
 */
public class AjaxJson {

    private Integer status=200;
    private String  message="success";
    private Object data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}