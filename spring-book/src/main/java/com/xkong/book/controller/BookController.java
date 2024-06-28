package com.xkong.book.controller;

import com.xkong.book.model.BookInfo;
import com.xkong.book.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-27
 * Time: 0:38
 * Version:
 */
@RequestMapping("/book")
@RestController
public class BookController {
    private BookService bookService = new BookService();

    @RequestMapping("/getBookList")
    public List<BookInfo> getBookList() {
        // 获取，处理和返回
        List<BookInfo> bookInfos = bookService.getBookList();
        return bookInfos;
    }
}
