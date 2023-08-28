package com.example.demospacebravo.interceptor;

import com.example.demospacebravo.entity.User;
import com.example.demospacebravo.utils.UserThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
        }
        User user = null;
        String token = request.getHeader("Authorization");
        String name = request.getHeader("name");
        Integer id = Integer.valueOf(request.getHeader("id"));

        if (token.equals("user")){
            user = new User(id,name);
        }else{
            return false;
        }
        UserThreadLocal.set(user);
        return true;
    }
}
