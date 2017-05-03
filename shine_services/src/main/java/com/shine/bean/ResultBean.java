package com.shine.bean;

/**
 * 结果bean
 */
public class ResultBean {

    final public static ResultBean SUCCESS = new ResultBean(true, "success");
    final public static ResultBean ERROR = new ResultBean(false, "error");

    protected boolean success;
    protected String msg;
    protected Object data;

    public ResultBean() {
    }

    private ResultBean(boolean success, String msg) {
        this(success, msg, null);
    }

    public ResultBean(boolean success, String msg, Object data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private ResultBean copyThis() {
        return new ResultBean(success, msg, null);
    }

    public static ResultBean error(String error) {
        return new ResultBean(ERROR.success, error);
    }

    public static ResultBean success(String error) {
        return new ResultBean(SUCCESS.success, error);
    }

    public static ResultBean success(Object object) {
        ResultBean r = ResultBean.SUCCESS.copyThis();
        r.setData(object);
        return r;
    }
}
