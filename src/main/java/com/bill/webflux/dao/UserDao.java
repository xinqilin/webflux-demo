package com.bill.webflux.dao;

import com.bill.webflux.model.User;

import java.util.Collection;

public interface UserDao {
    //查詢一個使用者
    public User findOne(Integer id);

    //查詢全部使用者
    public Collection<User> findAll();

    //新增一個使用者
    public void save(User user);

    //刪除一個使用者
    public void delete(User user);

    //更新一個使用者
    public void update(User user);
}
