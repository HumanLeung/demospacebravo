package com.example.demospacebravo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class CookieInterceptor implements HandlerInterceptor {

    private static final String COOKIES = "Cookie";

    private Map<String, String> cks = new HashMap<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String cookies = request.getHeader(COOKIES);
        if (cookies == null) {
            return true;
        }
        cks = new HashMap<>();
        Map<String, String> context = new HashMap<>();
        try {

        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    private String findCookieValue(String cookies, String k) {
        if (cks.isEmpty()) {
            loadCookiesMap(cookies);
        }
        return cks.get(k);
    }

    private void loadCookiesMap(String cookies) {
        String[] cookieArray = cookies.split(";");
        String[] kv = null;
        for (String c : cookieArray) {
            kv = c.split("=");
            if (kv.length == 2) {
                cks.put(kv[0].trim(), kv[1].trim());
            }
        }
    }
}
