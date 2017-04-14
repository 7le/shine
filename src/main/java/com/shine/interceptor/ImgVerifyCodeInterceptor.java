package com.shine.interceptor;

import com.shine.bean.ResultBean;
import com.shine.constant.HttpRequestParamNameConst;
import com.shine.constant.HttpSessionAttrNameConst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 图形验证码拦截器
 *
 * @author hq 2016/11/4
 */
public class ImgVerifyCodeInterceptor extends BaseInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession httpSession = request.getSession();
        //首先检查是否获取过验证码
        if (httpSession.getAttribute(HttpSessionAttrNameConst.VERIFYCODE_IMG_GET_FLAG) == null ||
                !(Boolean) httpSession.getAttribute(HttpSessionAttrNameConst.VERIFYCODE_IMG_GET_FLAG)) {

            doResponse(response, new ResultBean(false, "图形验证码错误",null));

            return false;
        }
        //无论验证是否成功,都移除该标志
        httpSession.removeAttribute(HttpSessionAttrNameConst.VERIFYCODE_IMG_GET_FLAG);


        String varifyCode_img_param = request.getParameter(HttpRequestParamNameConst.VERIFYCODE_IMG);

        //请求中参数不为空检查
        if (varifyCode_img_param == null || varifyCode_img_param == "") {

            doResponse(response, new ResultBean(false, "图形验证码错误",null));

            return false;
        }

        //session中数据不为空检查
        if (httpSession.getAttribute(HttpSessionAttrNameConst.VERIFYCODE_IMG) == null) {

            doResponse(response, new ResultBean(false, "图形验证码超时,请重新刷新获取",null));

            return false;
        }

        String varifyCode_img_data = (String) httpSession.getAttribute(HttpSessionAttrNameConst.VERIFYCODE_IMG);


        //不区分大小写比较
        if (!varifyCode_img_data.toLowerCase().equals(varifyCode_img_param.toLowerCase())) {

            doResponse(response, new ResultBean(false, "图形验证码错误",null));

            //同时移除验证码
            httpSession.removeAttribute(HttpSessionAttrNameConst.VERIFYCODE_IMG);

            return false;
        }

        //通过校验
        //校验成功也移除验证码
        httpSession.removeAttribute(HttpSessionAttrNameConst.VERIFYCODE_IMG);

        return true;
    }
}
