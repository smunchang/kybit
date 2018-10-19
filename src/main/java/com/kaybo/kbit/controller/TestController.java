package com.kaybo.kbit.controller;


import com.kaybo.kbit.model.Transaction;
import com.kaybo.kbit.service.TransactionService;
import com.kaybo.kbit.service.UserService;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


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
    public String makeReward(@RequestParam("userNo") long userNo,
                       @RequestParam("userId") String userId,
                       @RequestParam("type") String type,
                       @RequestParam("kbit") int kbit) throws IOException {

        userService.checkUser(userNo, userId);

        transactionService.makeRewardTransaction(userNo, type, kbit);

        return "OK";

    }


    @PostMapping("/transaction/reward/upload")
    @ResponseBody
    public String uploadReward(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException, URISyntaxException {

        String strDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
        Path pathDir = Paths.get(strDir);
        Files.createDirectories(pathDir);
        file.transferTo(new File(strDir + file.getOriginalFilename()));

        List<Transaction> transactions = new CsvToBeanBuilder(new FileReader(strDir + file.getOriginalFilename())).withType(Transaction.class).build().parse();


        transactionService.uploadRewardTransaction(transactions);
        return "OK";

    }


}
