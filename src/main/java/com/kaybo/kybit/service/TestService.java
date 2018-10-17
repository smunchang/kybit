package com.kaybo.kybit.service;

import com.kaybo.kybit.AppException;
import com.kaybo.kybit.model.Transaction;
import com.kaybo.kybit.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestService {
    private static Log logger = LogFactory.getLog(TestService.class);

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;





}
