package com.eyric.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/vue")
public class TestVueController {
    @RequestMapping("/index")
    public String index(HttpServletResponse response) {
        System.out.println(response);
        return "testVue/index";
    }
}
