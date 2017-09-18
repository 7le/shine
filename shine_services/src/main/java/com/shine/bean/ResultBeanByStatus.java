package com.shine.bean;

/**
 * 结果bean
 */
public class ResultBeanByStatus<T> {

    final public static ResultBeanByStatus SUCCESS = new ResultBeanByStatus(200, "success");
    final public static ResultBeanByStatus ERROR = new ResultBeanByStatus(400, "error");

    protected int status;
    protected String msg;
    protected T data;

    public ResultBeanByStatus() {
    }

    public ResultBeanByStatus(int status, String msg) {
        this(status, msg, null);
    }

    public ResultBeanByStatus(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private ResultBeanByStatus copyThis() {
        return new ResultBeanByStatus(status, msg, null);
    }

    public static ResultBeanByStatus error(String error) {
        return new ResultBeanByStatus(ERROR.status, error);
    }

    public static ResultBeanByStatus success(String error) {
        return new ResultBeanByStatus(SUCCESS.status, error);
    }

    public static ResultBeanByStatus success(Object object) {
        ResultBeanByStatus r = ResultBeanByStatus.SUCCESS.copyThis();
        r.setData(object);
        return r;
    }
}
