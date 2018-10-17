package com.kaybo.kybit.controller;


import com.kaybo.kybit.model.Transaction;
import com.kaybo.kybit.model.Type;
import com.kaybo.kybit.model.User;
import com.kaybo.kybit.service.TestService;
import com.kaybo.kybit.service.TransactionService;
import com.kaybo.kybit.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/test")
public class TestController {

    private static Log logger = LogFactory.getLog(TestController.class);

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transaction/reward")
    @ResponseBody
    public String test(@RequestParam("userNo") String userNo,
                       @RequestParam("userId") String userId,
                       @RequestParam("type") String type,
                       @RequestParam("kybit") int kybit) throws IOException {

        userService.checkUser(userNo, userId);
        Transaction transaction = new Transaction(userNo, type, kybit);

        transactionService.makeRewardTransaction(transaction);

        return "OK";

    }


    @GetMapping("/test")
    @ResponseBody
    public String xxxx() throws IOException {


        String type =  Type.valueOf("R000").getName();

        logger.error(type);
        return "OK";

    }


}
