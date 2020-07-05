package com.mzj.hellospringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private MyConfig myConfig;

    @GetMapping("/hello")
    public String say(){
        return "mazhongjia : " + myConfig.getMinMoney()+"----"+myConfig.getDescription();
    }

    @GetMapping({"hello2","hello3"})
    public String say2ForOne(){
        return "say2ForOne : " + myConfig.getMinMoney()+"----"+myConfig.getDescription();
    }

    @GetMapping("/say/{id}")
    public String say2PathVariable(@PathVariable("id") Integer id){
        return "id : " + id;
    }

    @GetMapping("/say2")
    public String say2RequestParam(@RequestParam("id") Integer id){
        return "id:RequestParam : " + id;
    }

    @GetMapping("/say3")
    public String say2RequestParam2(@RequestParam(value = "id",required = false,defaultValue = "-1") Integer id){
        return "id:RequestParam2 : " + id;
    }
}
