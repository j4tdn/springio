package com.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {

    @Value("${exception.name}")
    private String exceptionName;

    @Value("${exception.info}")
    private String exceptionInfo;

    @GetMapping("/exception/info")
    public String exception() {
        return exceptionName + " - " + exceptionInfo;
    }

    @RequestMapping("/")
    public String index() {
        return "Happy new year - Welcome - 2022";
    }


}
