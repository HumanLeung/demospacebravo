package com.example.demospacebravo.controller;


import com.example.demospacebravo.entity.User;
import com.example.demospacebravo.utils.UserThreadLocal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public void test(){
        User user = UserThreadLocal.get();
        System.out.println(user);
    }
    @GetMapping("/t2")
    public void test02(){
//        User user = UserThreadLocal.get();
//        System.out.println(user);
        System.out.println("t2");
    }
}
