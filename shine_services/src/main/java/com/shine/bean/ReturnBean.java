package com.shine.bean;

/**
 * 返回json类型 用户AJAX请求
 * Created by hq on 2016/11/04
 */
public class ReturnBean {
    private boolean success;
    private String message;
    private String url;


    public ReturnBean() {
    }

    public ReturnBean(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ReturnBean(boolean success, String message, String url) {
        this.success = success;
        this.message = message;
        this.url = url;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
