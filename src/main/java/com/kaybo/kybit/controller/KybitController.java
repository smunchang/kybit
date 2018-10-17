package com.kaybo.kybit.controller;


import com.kaybo.kybit.service.TestService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/kybit")
public class KybitController {

    private static Log logger = LogFactory.getLog(KybitController.class);

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private TestService testService;

    @GetMapping("/getBalan/{gameNo}")
    @ResponseBody
    public String test(@RequestHeader("userNo") String userNo,
                       @RequestHeader("userId") String userId,
                       @PathVariable String gameNo) throws IOException {
        //testService.testMethod();
        return "OK";

    }


}
