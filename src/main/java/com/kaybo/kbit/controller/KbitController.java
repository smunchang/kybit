package com.kaybo.kbit.controller;


import com.kaybo.kbit.model.Transaction;
import com.kaybo.kbit.model.User;
import com.kaybo.kbit.service.TransactionService;
import com.kaybo.kbit.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/kbit")
public class KbitController {

    private static Log logger = LogFactory.getLog(KbitController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/user")
    @ResponseBody
    public User getUserInfo(@RequestHeader("userNo") long userNo,
                            @RequestHeader("userId") String userId) {
        User user = userService.selectUser(userNo);
        return user;

    }

    @GetMapping("/history")
    @ResponseBody
    public List<Transaction> listTransaction(@RequestHeader("userNo") long userNo,
                                             @RequestHeader("userId") String userId,
                                             @RequestHeader(value="offset", required = false) String offset,
                                             @RequestHeader(value="limit", required = false) String limit)  {

        List<Transaction> transactions = transactionService.listTransaction(userNo, offset, limit);
        return transactions;

    }


}
