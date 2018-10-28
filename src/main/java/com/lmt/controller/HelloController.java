package com.lmt.controller;

import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 热带雨林 on 2018/10/28.
 */
@org.springframework.stereotype.Controller
public class HelloController implements Controller {
    @RequestMapping("/hello.form")
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res)
            throws Exception {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("jsp/hello");
        mav.getModel().put("message", "模型数据");
        return mav;
    }
}