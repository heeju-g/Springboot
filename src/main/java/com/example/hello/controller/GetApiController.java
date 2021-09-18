package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {
    @GetMapping(path = "/hello") //http://localhost:9090/api/get/hello
    public String hello(){
        return "get hello";
    }


    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    //예전 방식 : request mappring하면 get/post/put/delete 가 모두 매핑되게 되기 때문에 지정해줘야 한다.
    public String hi(){
        return "hi";
    }

    //path variable 변화하는 부분 http://localhost:9090/api/get/path-variable/{name}
    //getMappring에 적은 {} 이름 맞춰줘한다.
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName){
        System.out.println("PathVariable: "+pathName);
        return pathName;
    }

    //query parameter : 검색을 할 때 여러 매개변수의 인자
    //http://localhost:9090/api/get/query-param?name=heeju&emmail=heeju01226@gmail.com&age=26
    //방법 1 map의 형태로 무한정 받는다.
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String,String> queryParam){
        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+" = "+entry.getValue()+"\n");

        });
        return sb.toString();
    }
    //방법 2. 명시적으로 변수로 받을 때, 각 변수에 어노테이션 달아주면 된다.
    @GetMapping("query-param02")
    public String queryParam02(@RequestParam String name,@RequestParam String email, @RequestParam int age){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
      return name+" "+email+" "+age;
    }
    //방법 3. 변수가 많아지는 경우 dto형태로 받는다. requestparam어노테이션 안붙인다.(가장 많이 쓰이는 방법)
    //?뒤의 값들을 스프링부트에서 판단하고, 변수(키)에 해당하는 부분을 이름 매칭해서 넣어준다.
    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());
        return userRequest.toString();
    }

}
