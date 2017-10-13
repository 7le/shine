package com.shine.bean;

/**
 * 支持参数的调用接口，并且实现了runable,callable接口
 * Created by hq on 2017/10/13
 */
public interface Invokable<R,P>{
	
	/**
	 * 调用方法并返回结果
	 * @param m
	 * @return
	 */
	public R call(P m);
}
