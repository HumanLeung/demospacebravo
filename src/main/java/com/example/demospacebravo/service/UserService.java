package com.example.demospacebravo.service;


import org.springframework.stereotype.Service;

@Service
public class UserService {

    public boolean login(String userId){
        return userId.equals("123");
    }
}
