package com.du.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService{

    @Autowired
    private BookShopDao bookShopDao;

    //添加事务注解
    //1、使用propagation指定事务的传播行为，即当前的事务方法被另外一个事务方法调用时
    //如何使用事务，默认取值 REQUIRED，即使用调用方法的事务。例如买2本书的事务调用该事务 Cashier.checkout()，用户剩余金额只够买第一本书，此时会2本都购买不成功。
    //REQUIRES_NEW 使用自己的事务，调用方法的事务被挂起。例如买2本书的事务调用该事务 Cashier.checkout()，用户剩余金额只够买第一本书，此时会第一本购买成功，第二本购买失败。
    //2、使用isolation指定事务的隔离级别，最常用的取值为READ_COMMITTED
    //3、默认情况下对所有运行时异常进行回滚，也可以通过对应的属性进行设置，noRollbackFor和noRollbackForClassName 进行不回滚设置 noRollbackFor = {UserAccountException.class}
    //rollbackFor和 rollbackForClassName 对哪些异常回滚进行设置
    //通常情况下取默认值即可，并不进行设置。
    //4、readOnly 指定事务是否为只读。表示这个事务只读取数据但不更新数据，这样可以帮助数据库引擎优化事务。
    //5、timeout 单位为秒，指定强制回滚之前可以占用的时间，超时会强制回滚
    @Transactional(propagation = Propagation.REQUIRED,
    isolation = Isolation.READ_COMMITTED)
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
