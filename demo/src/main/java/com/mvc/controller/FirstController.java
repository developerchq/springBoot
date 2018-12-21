package com.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mvc.model.FirstModel;
import com.mvc.service.FirstService;

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
    public ModelAndView Index(String str,@ModelAttribute("message") String message){
        FirstModel firstModel = new FirstModel();
        //String reStr = firstService.getSomethingFromService(str,firstModel);
        ModelAndView modelAndView = new ModelAndView("index");
        //当设置false时不生成静态页面
        modelAndView.addObject("STATIC_HTML", false);
        modelAndView.addObject("message",message);
        List<FirstModel> list = firstService.findAll();
        modelAndView.addObject("list",list);
        return modelAndView;
    }


    /**
     * 按id查找（restful风格请求）
     * http://localhost:9094/spring-boot/query/1其中1表示id=1，必须对应@PathVariable(value="id")参数接收
     * @param id
     * @return
     */
    @RequestMapping(value="/query/{id}", method=RequestMethod.GET)
    public ModelAndView query(@PathVariable(value="id") String id){
    	log.info("更新操作");
        ModelAndView modelAndView = new ModelAndView("update");
        FirstModel firstModel = firstService.selectByPrimaryKey(id);

        modelAndView.addObject("firstModel", firstModel);
        return modelAndView;
    }
    
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @ResponseBody
    public ModelAndView update(FirstModel firstModel,RedirectAttributes redirectAttributes){
    	log.info("更新操作");
//        Map<String, Object> map=new HashMap<String, Object>();
    	ModelAndView modelAndView = new ModelAndView("redirect:/index");
        int result = firstService.update(firstModel);
        if(result>0) {
        	redirectAttributes.addFlashAttribute("message", "success");
        	//map.put("message","success");
        }else {
        	redirectAttributes.addFlashAttribute("message", "error");
        	//map.put("message","error");
		}
        //map.put("firstModel", firstModel);
        return modelAndView;
    }
    
    @RequestMapping(value="/insert", method=RequestMethod.POST)
    public String insert(FirstModel firstModel,RedirectAttributes redirectAttributes){
    	log.info("insert操作");
    	//是否存在ID重复
    	FirstModel bean = firstService.selectByPrimaryKey(firstModel.getId());
    	if(bean!=null) {
    		redirectAttributes.addFlashAttribute("message", "error,ID exist");
    		return "redirect:index";
    	}
        Map<String, Object> map=new HashMap<String, Object>();
        int result = firstService.insert(firstModel);
        if(result>0) {
        	redirectAttributes.addFlashAttribute("message", "success");
        	//map.put("message","success");
        }else {
        	redirectAttributes.addFlashAttribute("message", "error");
        	//map.put("message","error");
		}
        //map.put("firstModel", firstModel);
        return "redirect:index";
    }
    
    /**
     * RedirectAttributes是SpringMVC3.1版本之后出来的一个功能，专门用于重定向之后还能带参数跳转的.
     * 防止暴露参数
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public ModelAndView delete(@PathVariable(value="id") String id,RedirectAttributes redirectAttributes){
    	log.info("delete操作");
        ModelAndView modelAndView = new ModelAndView("redirect:/index");
        int result = firstService.delete(id);
        if(result>0) {
        	redirectAttributes.addFlashAttribute("message", "success");
        	// modelAndView.addObject("message", "success");
        	 return modelAndView;
        }
       
        return modelAndView;
    }
}
