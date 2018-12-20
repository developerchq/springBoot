package com.mvc.controller;

import com.mvc.model.FirstModel;
import com.mvc.service.FirstService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by AB052409 on 2016/12/5.
 */
@Controller
@EnableAutoConfiguration
public class FirstController {
	private final Logger log = LoggerFactory.getLogger(FirstController.class);
    @Autowired
    private FirstService firstService;

    @RequestMapping("hello")
    @ResponseBody
    public String Hello(String str){
    	log.info("FirstController hello method");
        FirstModel firstModel = new FirstModel();
        String reStr = firstService.getSomethingFromService(str,firstModel);
        log.info("data:"+reStr);
        return reStr;
    }

    @RequestMapping("index")
    public ModelAndView Index(String str){
        FirstModel firstModel = new FirstModel();
        String reStr = firstService.getSomethingFromService(str,firstModel);
        ModelAndView modelAndView = new ModelAndView("index");
        //当设置false时不生成静态页面
        modelAndView.addObject("STATIC_HTML", false);

        modelAndView.addObject("content",reStr);
        return modelAndView;
    }


    @RequestMapping("html/index")
    public ModelAndView htmlIndex(){
        ModelAndView modelAndView = new ModelAndView("index");
        //默认是生成静态页面的
        modelAndView.addObject("content", "网站标题1");
        return modelAndView;
    }

    //jsp测试
    @RequestMapping("jsp/index")
    public ModelAndView jspindex(){
        ModelAndView modelAndView = new ModelAndView("test");
        modelAndView.addObject("content", "网站标题");
        return modelAndView;
    }
}
