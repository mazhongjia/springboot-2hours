package com.mzj.hellospringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController4Html {

    @Autowired
    private MyConfig myConfig;

    @GetMapping("/hello1")
    public String say(){
        return "hh";
    }
}
