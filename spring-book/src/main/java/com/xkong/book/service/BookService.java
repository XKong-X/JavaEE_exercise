package com.xkong.book.service;

import com.xkong.book.dao.BookDao;
import com.xkong.book.model.BookInfo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-27
 * Time: 16:27
 * Version:
 */
public class BookService {
    private BookDao bookDao = new BookDao();

    public List<BookInfo> getBookList() {
        List<BookInfo> bookInfos = bookDao.mockData();
        for (BookInfo bookInfo : bookInfos) {
            if (bookInfo.getStatus() == 1) {
                bookInfo.setStatusCN("可借阅");
            } else {
                bookInfo.setStatusCN("不可借阅");
            }
        }
        return bookInfos;
    }
}
