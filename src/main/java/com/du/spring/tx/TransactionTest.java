package com.du.spring.tx;

import com.du.spring.jdbc.DepartmentDao;
import com.du.spring.jdbc.EmployeeDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testng.annotations.Test;

public class TransactionTest {
    private ApplicationContext ctx;
    private BookShopDao bookShopDao;
    private BookShopService bookShopService;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext-Tx.XML");
        bookShopDao = ctx.getBean(BookShopDao.class);
        bookShopService = ctx.getBean(BookShopService.class);

    }

    @Test
    public void testPurchase(){
        bookShopService.purchase("AA","1001");
    }


    @Test
    public void TestUpdateUserAccount(){
        bookShopDao.updateUserAccount("AA",100);
    }

    @Test
    public void testUpdateBookStock(){
        bookShopDao.updateBookStock("1001");

    }

    @Test
    public void testFindBookPriceByIsbn(){
        System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
    }

}
