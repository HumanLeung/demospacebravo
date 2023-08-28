package com.example.demospacebravo.utils;

import com.example.demospacebravo.entity.User;

public class UserThreadLocal {
    private static final ThreadLocal<User> USER_THREAD_LOCAL = new ThreadLocal<>();
    private UserThreadLocal(){}

    public static void set(User user){
        USER_THREAD_LOCAL.set(user);
    }
    public static User get(){
        return USER_THREAD_LOCAL.get();
    }
}
