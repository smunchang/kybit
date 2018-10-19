package com.kaybo.kbit.service;

import com.kaybo.kbit.AppException;
import com.kaybo.kbit.model.Transaction;
import com.kaybo.kbit.model.Type;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class TransactionService {
    private static Log logger = LogFactory.getLog(TransactionService.class);

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private UserService userService;


    public List<Transaction> listTransaction(long userNo, String offset, String limit){

        List<Transaction> transactions;
        if(offset == null || limit == null){
            transactions = sqlSessionTemplate.selectList("transaction.listTransaction", userNo);
        }else{
            RowBounds rowBounds = new RowBounds(Integer.parseInt(offset), Integer.parseInt(limit));
            transactions = sqlSessionTemplate.selectList("transaction.listTransaction", userNo, rowBounds);
        }

        return transactions;
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

    @Transactional
    public void makeRewardTransaction(long userNo, String type, int kbit){
        Transaction transaction = new Transaction();
        transaction.setUserNo(userNo);
        transaction.setType(type);
        transaction.setKbit(kbit);
        try{
            if(!checkType(transaction.getType())){
                throw new AppException( 10000, "Wrong Type");
            }
            sqlSessionTemplate.insert("transaction.insertTransaction", transaction);
            sqlSessionTemplate.update("user.updateKbitPlus", transaction);
        }catch (Exception e){
            throw new AppException( 99999, e.getMessage());
        }

    }

    @Transactional
    public void uploadRewardTransaction(List<Transaction> transactions){


        for(Transaction transaction : transactions){
            if(!checkType(transaction.getType())){
                throw new AppException( 10000, "Wrong Type");
            }

            userService.checkUser(transaction.getUserNo(), transaction.getUserId());

            sqlSessionTemplate.insert("transaction.insertTransaction", transaction);
            sqlSessionTemplate.update("user.updateKbitPlus", transaction);
        }

    }


}
