package com.shine.bean;


/**
 * 返回json数据
 * Created by hq on 2016/12/2.
 */
public class AjaxJson {

    final public static AjaxJson SUCCESS = new AjaxJson(200, "success");
    final public static AjaxJson ERROR = new AjaxJson(500, "error");

    private Integer status;
    private String  msg;
    private Object data;

    public AjaxJson() {
    }

    private AjaxJson(Integer status, String msg) {
        this(status, msg, null);
    }

    public AjaxJson(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private AjaxJson copyThis() {
        return new AjaxJson(status, msg, null);
    }

    public static AjaxJson error(String error) {
        return new AjaxJson(ERROR.status, error);
    }

    public static AjaxJson success(Object object) {
        AjaxJson r = AjaxJson.SUCCESS.copyThis();
        r.setData(object);
        return r;
    }

}
