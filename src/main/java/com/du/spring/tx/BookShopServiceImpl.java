package com.du.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService{

    @Autowired
    private BookShopDao bookShopDao;

    //添加事务注解
    //使用propagation指定事务的传播行为，即当前的事务方法被另外一个事务方法调用时
    //如何使用事务，默认取值 REQUIRED，即使用调用方法的事务。例如买2本书的事务调用该事务 Cashier.checkout()，用户剩余金额只够买第一本书，此时会2本都购买不成功。
    //REQUIRES_NEW 使用自己的事务，调用方法的事务被挂起。例如买2本书的事务调用该事务 Cashier.checkout()，用户剩余金额只够买第一本书，此时会第一本购买成功，第二本购买失败。
    @Transactional(propagation = Propagation.REQUIRED)
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
