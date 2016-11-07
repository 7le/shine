package com.shine.controller;

import com.shine.constant.HttpSessionAttrNameConst;
import com.shine.util.validate.ValidateCode;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.word.RandomWordFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 公共控制器
 */
@Controller
@RequestMapping("")
public class CommonsController extends BaseController {

    /**
     * 图形验证生成相关对象
     */
    private static ConfigurableCaptchaService configurableCaptchaService = new ConfigurableCaptchaService();
    private static RandomWordFactory randomWordFactory = new RandomWordFactory();

    //图形验证码配置
    static {
        randomWordFactory.setCharacters("0123456789abcdefghigkmnpqrstuvwxyzABCDEFGHIGKLMNPQRSTUVWXYZ");
        randomWordFactory.setMaxLength(4);
        randomWordFactory.setMinLength(4);
        configurableCaptchaService.setWordFactory(randomWordFactory);
        configurableCaptchaService.setHeight(200);
        configurableCaptchaService.setHeight(80);
    }


    /**
     * 获取图像验证码
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/getVerifyCodeImg")
    public void getVerifyCodeImg(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        //获得该session
        HttpSession httpSession = request.getSession();

        // 设置响应的类型格式为图片格式
        response.setContentType("image/png");
        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        //设置验证码输出
        ValidateCode vCode = new ValidateCode(120, 40, 4, 0);
        vCode.write(response.getOutputStream());
        response.getOutputStream().close();

        //将验证码保存到session
        httpSession.setAttribute(HttpSessionAttrNameConst.VERIFYCODE_IMG, vCode.getCode());
        //获取过有效验证码标志
        httpSession.setAttribute(HttpSessionAttrNameConst.VERIFYCODE_IMG_GET_FLAG, true);

//        System.out.println("图形验证码[" + vCode.getCode() + "]");
    }

    /**
     * ueitor编辑器请求入口
     *
     * @param request
     * @param response
     */
    @RequestMapping("/ueditor/**")
    public void UeditorEnter(HttpServletRequest request,
                             HttpServletResponse response) throws ServletException, IOException {

        //根据action进行转发
        request.getRequestDispatcher(request.getParameter("action") == null ? "" : request.getParameter("action")).forward(request,response);
    }

}
