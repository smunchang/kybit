package com.kaybo.kybit.service;

import com.kaybo.kybit.AppException;
import com.kaybo.kybit.model.Transaction;
import com.kaybo.kybit.model.Type;
import com.kaybo.kybit.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TransactionService {
    private static Log logger = LogFactory.getLog(TransactionService.class);

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Transactional
    public void makeRewardTransaction(Transaction transaction){
        try{
            if(!checkType(transaction.getType())){
                throw new AppException( 10000, "Bad Type");
            }
            sqlSessionTemplate.insert("transaction.insertTransaction", transaction);
            sqlSessionTemplate.update("user.updateKybitPlus", transaction);
        }catch (Exception e){
            throw new AppException( 99999, e.getMessage());
        }




    }


    private boolean checkType(String t){
        boolean result = false;
        for(Type type : Type.values()){
            if(type.name().equals(t)){
                result = true;
                break;
            }
        }
        return result;
    }
}
