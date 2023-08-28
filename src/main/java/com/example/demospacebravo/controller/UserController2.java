package com.example.demospacebravo.controller;

import com.example.demospacebravo.entity.User;
import com.example.demospacebravo.utils.UserThreadLocal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController2 {

    @GetMapping("/t3")
    public void test02(){
        System.out.println("t3");
    }
}
