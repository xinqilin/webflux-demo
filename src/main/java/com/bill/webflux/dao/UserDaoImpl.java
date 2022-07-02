package com.bill.webflux.dao;

import com.bill.webflux.model.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserDaoImpl implements UserDao{
    //模擬資料庫中的資料
    private final Map<Integer, User> users = new ConcurrentHashMap<>();

    //呼叫無參構造初始化
    public UserDaoImpl() {
        users.put(1, new User(1, "Bill", "Male", 10));
        users.put(2, new User(2, "Paul", "Female", 20));
        users.put(3, new User(3, "David", "Male", 30));
    }

    @Override
    public User findOne(Integer id) {
        return users.get(id);
    }

    @Override
    public Collection<User> findAll() {
        return users.values();
    }

    @Override
    public void save(User user) {
        int id = users.size() + 1;
        user.setId(id);
        users.put(id, user);
    }

    @Override
    public void delete(User user) {
        users.remove(user.getId());
    }

    @Override
    public void update(User user) {
        int id = user.getId();
        users.remove(id);
        users.put(id, user);
    }
}
