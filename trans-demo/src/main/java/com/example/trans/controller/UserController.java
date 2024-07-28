package com.example.trans.controller;

import com.example.trans.mapper.UserInfoMapper;
import com.example.trans.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-28
 * Time: 16:36
 * Version:
 */
@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;
    @Autowired
    private TransactionDefinition transactionDefinition;


    @Autowired
    private UserService userService;

    @RequestMapping("/registry")
    public String registry(String userName, String password) {
        // 开启事务
        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(transactionDefinition);
        Integer result = userService.insertUser(userName, password);
        log.info("插入成功, result:" + result);

        // 回滚
//        dataSourceTransactionManager.rollback(transaction);
        // 提交
        dataSourceTransactionManager.commit(transaction);
        return  "...";
    }
}
