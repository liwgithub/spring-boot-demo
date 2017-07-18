package com.baiding.boot.dao;

import com.baiding.boot.model.Account;

import java.util.List;

/**
 * Created by BaiDing on 2017/7/13.
 */
public interface AccountDAO {
    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();
}
