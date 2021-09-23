package com.example.hello;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("-------------");

        //objectmapper : 텍스트 형태의 json을 object로, object를 text json으로 바꿔준다.
        //controller req json(text) -> object
        //response object -> json(text)
        var objectMapper = new ObjectMapper();

        //object -> text : object mapper가 get method를 활용한다.
        var user = new User("HEEJU",10,"010-1111-2222");
        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        //text -> object : default 생성자가 필요하다. (User 클래스에)
        var objectUser = objectMapper.readValue(text,User.class);
        System.out.println(objectUser);

    }

}
