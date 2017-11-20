package com.du.spring.tx;

public interface BookShopService {
    /**
     * 买书方法
     * @param username
     * @param isbn
     */
    void purchase(String username, String isbn);
}
