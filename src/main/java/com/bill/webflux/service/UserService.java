package com.bill.webflux.service;

import com.bill.webflux.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    //查詢一個使用者
    public Mono<User> findOne(Integer id);

    //查詢全部使用者
    public Flux<User> findAll();

    //新增一個使用者
    public Mono<Void> save(Mono<User> userMono);

    //刪除一個使用者
    public Mono<Void> delete(Mono<User> userMono);

    //更新一個使用者
    public Mono<Void> update(Mono<User> userMono);
}
