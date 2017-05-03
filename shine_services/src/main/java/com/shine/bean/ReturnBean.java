package com.shine.bean;

/**
 * 返回json类型 用户AJAX请求
 * Created by hq on 2016/11/04
 */
public class ReturnBean {

    final public static ReturnBean SUCCESS = new ReturnBean(true, "success");
    final public static ReturnBean ERROR = new ReturnBean(false, "error");

    private boolean success;
    private String msg;
    private String url;


    public ReturnBean() {
    }

    private ReturnBean(boolean success, String msg) {
        this(success, msg, null);
    }

    public ReturnBean(boolean success, String msg, String url) {
        this.success = success;
        this.msg = msg;
        this.url = url;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private ReturnBean copyThis() {
        return new ReturnBean(success, msg, null);
    }

    public static ReturnBean error(String error) {
        return new ReturnBean(ERROR.success, error);
    }

    public static ReturnBean success(String object) {
        ReturnBean r = ReturnBean.SUCCESS.copyThis();
        r.setUrl(object);
        return r;
    }

}
