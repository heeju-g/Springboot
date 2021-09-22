package com.example.hello.controller;

import com.example.hello.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ResponseApiController {
    //text(거의 이렇게 사용 안 함.
    @GetMapping("/text")
    public String text(@RequestParam String account){
        return account;
    }
    //json 오브젝트를 내려주는 방법
    //request가 오면 -> object mapper -> object -> method -> object -> object mapper -> json -> response
    @PostMapping("/json")
    public User json(@RequestBody User user){
        return user; //200 ok
    }
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user){
        //resource가 생성되면 명확하게 값(201)을 내려준다. 아래코드처럼 바디에 데이터를 넣어줄 수도 있다.
         return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
