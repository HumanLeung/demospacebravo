package com.example.demospacebravo.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConstantMap {

    public static void main(String[] args) {
        String s = "{ }";
        s = s.charAt(0) + " \n    new content\n"+ s.charAt(s.length() - 1);
        System.out.println(s);
        mapTest();
    }

    public static void example2() {
        String curlyString = "{userCode}";
        System.out.println(
                curlyString.replaceAll("\\{userCode\\}", "MYUSERCODE"));
    }

    public static void mapTest(){
        Map<String ,String> map = new HashMap<>();
        map.put("customer.id","renderType");

        for (Map.Entry<String,String> key: map.entrySet()){
            if (key.getKey().equals("customer.id")){
                System.out.println(true);
            }
        }
    }
}
