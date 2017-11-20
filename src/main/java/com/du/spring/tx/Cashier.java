package com.du.spring.tx;

import java.util.List;

public interface Cashier {

    /**
     * 购买多本书
     * @param username
     * @param isbns
     */
    void checkout(String username, List<String> isbns);
}
