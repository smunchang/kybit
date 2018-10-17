package com.kaybo.kybit.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

@Controller
public class MyController {

    private static Log logger = LogFactory.getLog(MyController.class);

    @Value("${spring.mvc.view.suffix}")
    private String authUrl;

/*    @GetMapping("/aaaa")
    public String main() {
        ModelAndView view = new ModelAndView("index");
        view.addObject("text", "world");
        return view;

        model.put("time", new Date());
        model.put("message", this.message);
        return "welcome";
    }*/


    @RequestMapping("/welcome")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());

        logger.error(authUrl);
        //model.put("message", this.message);
        return "welcome";
    }



}