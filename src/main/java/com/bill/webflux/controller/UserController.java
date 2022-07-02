package com.bill.webflux.controller;

import com.bill.webflux.model.User;
import com.bill.webflux.service.UserService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@RestController
//@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //查詢一個使用者
    @GetMapping("/findOne/{id}")
    public Mono<User> findOne(@PathVariable Integer id) {
        return userService.findOne(id);
    }

    //查詢全部使用者
    @GetMapping("/findAll")
    public Flux<User> findAll() {
        return userService.findAll();
    }

    //新增一個使用者
    @PostMapping("/save")
    public Mono<Void> save(@RequestBody User user) {
        Mono<User> userMono = Mono.just(user);
        return userService.save(userMono);
    }

    //刪除一個使用者
    @PostMapping("/delete")
    public Mono<Void> delete(@RequestBody User user) {
        Mono<User> userMono = Mono.just(user);
        return userService.delete(userMono);
    }

    //更新一個使用者
    @PostMapping("/update")
    public Mono<Void> update(@RequestBody User user) {
        Mono<User> userMono = Mono.just(user);
        return userService.update(userMono);
    }
}
