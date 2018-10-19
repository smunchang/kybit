package com.kaybo.kbit.service;

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
