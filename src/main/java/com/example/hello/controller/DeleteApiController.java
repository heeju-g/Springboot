package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DeleteApiController {
    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable String userId, @RequestParam String account){
        System.out.println(userId);
        System.out.println(account);
        //delete 자체가 리소스 삭제이다. 때문에 이미 리소스가 없다고 해서 에러를 던지는 게 아니라 200 ok를 던진다.
    }
}
