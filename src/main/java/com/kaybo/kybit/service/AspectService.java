package com.kaybo.kybit.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AspectService {

    private static Log logger = LogFactory.getLog(AspectService.class);

    @Value("${auth.url}")
    private String authUrl;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private UserService userService;

    @Before("execution(* com.kaybo.kybit.controller.KybitController.*(..))")
    public void onBeforeHandler(JoinPoint joinPoint) {

        ServletRequestAttributes t = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = t.getRequest();
        String userNo = request.getHeader("userNo");
        String userId = request.getHeader("userId");

        userService.checkUser(userNo, userId);
    }

}
