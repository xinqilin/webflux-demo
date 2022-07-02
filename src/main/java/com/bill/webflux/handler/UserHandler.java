package com.bill.webflux.handler;

import com.bill.webflux.model.User;
import com.bill.webflux.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {

    private final UserService userService;

    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    //查詢一個使用者
    public Mono<ServerResponse> findOne(ServerRequest request) {
        //獲取id值
        int id = Integer.parseInt(request.pathVariable("id"));
        Mono<User> userMono = userService.findOne(id);
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userMono, User.class);
    }

    //查詢全部使用者
    public Mono<ServerResponse> findAll(ServerRequest request) {
        Flux<User> userFlux = userService.findAll();
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userFlux, User.class);
    }

    //新增一個使用者
    public Mono<ServerResponse> save(ServerRequest request) {
        //獲取user值
        Mono<User> userMono = request.bodyToMono(User.class);
        return ServerResponse.ok().build(userService.save(userMono));
    }

    //刪除一個使用者
    public Mono<ServerResponse> delete(ServerRequest request) {
        //獲取user值
        Mono<User> userMono = request.bodyToMono(User.class);
        return ServerResponse.ok().build(userService.delete(userMono));
    }

    //更新一個使用者
    public Mono<ServerResponse> update(ServerRequest request) {
        //獲取user值
        Mono<User> userMono = request.bodyToMono(User.class);
        return ServerResponse.ok().build(userService.update(userMono));
    }
}
