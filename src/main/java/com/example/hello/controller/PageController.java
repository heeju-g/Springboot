package com.example.hello.controller;

import com.example.hello.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
    @RequestMapping("/main")
    public String main(){
        return "main.html";
    }
    
    //response entity
    @ResponseBody
    @GetMapping("/user")
    public User user(){
        //타입추론
        var user = new User();
        user.setName("heeju");
        user.setAddress("seoul");
        user.setAge(26);
        user.setPhoneNumber("010-0000-0000");
        return user;
    }
}
