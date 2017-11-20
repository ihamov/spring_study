package com.du.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService{

    @Autowired
    private BookShopDao bookShopDao;

    //添加事务注解
    @Transactional
    @Override
    public void purchase(String username, String isbn) {
        //获取书的单价
        int price = bookShopDao.findBookPriceByIsbn(isbn);

        //更新书的库存
        bookShopDao.updateBookStock(isbn);

        //更新用户余额
        bookShopDao.updateUserAccount(username, price);

    }
}
