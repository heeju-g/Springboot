package com.example.hello.controller;

import com.example.hello.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ResponseApiController {
    //text(거의 이렇게 사용 안 함.
    @GetMapping("/text")
    public String text(@RequestParam String account){
        return account;
    }
    //json
    //request가 오면 -> object mapper -> object -> method -> object -> object mapper -> json -> response
    @PostMapping("/json")
    public User json(@RequestBody User user){
        return user;
    }

}
