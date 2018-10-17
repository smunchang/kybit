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
public class UserService {
    private static Log logger = LogFactory.getLog(UserService.class);

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public void checkUser(String user_no, String user_id){
        User user = new User(user_no, user_id);
        boolean chk = sqlSessionTemplate.selectOne("user.checkUser", user.getUserNo());
        if(!chk){
            sqlSessionTemplate.insert("user.insertUser", user);
        }
    }
}
