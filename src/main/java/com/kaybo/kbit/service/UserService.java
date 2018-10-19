package com.kaybo.kbit.service;

import com.kaybo.kbit.model.User;
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

    public void checkUser(long user_no, String user_id){
        User user = new User();
        user.setUserNo(user_no);
        user.setUserId(user_id);
        boolean chk = sqlSessionTemplate.selectOne("user.checkUser", user.getUserNo());
        if(!chk){
            sqlSessionTemplate.insert("user.insertUser", user);
        }
    }

    public User selectUser(long user_no){
        User user = sqlSessionTemplate.selectOne("user.selectUser", user_no);
        return user;
    }
}
