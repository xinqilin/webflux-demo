package com.bill.webflux.service;

import com.bill.webflux.dao.UserDao;
import com.bill.webflux.model.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Mono<User> findOne(Integer id) {
        return Mono.justOrEmpty(userDao.findOne(id));
    }

    @Override
    public Flux<User> findAll() {
        return Flux.fromIterable(userDao.findAll());
    }

    @Override
    public Mono<Void> save(Mono<User> userMono) {
        return userMono.doOnNext(user -> {
            //儲存一個使用者
            userDao.save(user);
        }).thenEmpty(Mono.empty());
    }

    @Override
    public Mono<Void> delete(Mono<User> userMono) {
        return userMono.doOnNext(user -> {
            //刪除一個使用者
            userDao.delete(user);
        }).thenEmpty(Mono.empty());
    }

    @Override
    public Mono<Void> update(Mono<User> userMono) {
        return userMono.doOnNext(user -> {
            //更新一個使用者
            userDao.update(user);
        }).thenEmpty(Mono.empty());
    }
}
