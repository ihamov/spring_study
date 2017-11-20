package com.du.spring.tx;

import com.du.spring.jdbc.DepartmentDao;
import com.du.spring.jdbc.EmployeeDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testng.annotations.Test;

import java.util.Arrays;

public class TransactionTest {
    private ApplicationContext ctx;
    private BookShopDao bookShopDao;
    private BookShopService bookShopService;
    private Cashier cashier;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext-Tx.XML");
        bookShopDao = ctx.getBean(BookShopDao.class);
        bookShopService = ctx.getBean(BookShopService.class);
        cashier = ctx.getBean(Cashier.class);

    }

    @Test
    public void testTransactionPropagation(){
        cashier.checkout("AA", Arrays.asList("1001","1002"));

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
