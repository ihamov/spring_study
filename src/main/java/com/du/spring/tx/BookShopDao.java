package com.du.spring.tx;

/**
 create table book(
 isbn varchar(50) primary key,
 book_name varchar(100),
 price int
 );

 create table book_stock(
 isbn varchar(50) primary key,
 stock int,
 check(stock > 0)
 );

 create table account(
 username varchar(50) primary key,
 balance int,
 check(balance > 0)
 );

 */

public interface BookShopDao {

    /**
     * 根据书号获取书的单价
     * @param isbn
     * @return
     */
    int findBookPriceByIsbn(String isbn);

    /**
     * 根据书号，更新书的库存
     * @param isbn
     */
    void updateBookStock(String isbn);

    /**
     * 更新用户的账户余额
     * @param username
     * @param price
     */
    void updateUserAccount(String username, int price);
}
