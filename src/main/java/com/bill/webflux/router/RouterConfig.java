package com.bill.webflux.router;

import com.bill.webflux.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RouterConfig {
    @Bean
    public RouterFunction<ServerResponse> userRouter(UserHandler userHandler) {
        return RouterFunctions
                .route(GET("/user/{id}").and(accept(MediaType.APPLICATION_JSON)), userHandler::findOne)
                .andRoute(GET("/user").and(accept(MediaType.APPLICATION_JSON)), userHandler::findAll)
                .andRoute(POST("/user").and(accept(MediaType.APPLICATION_JSON)), userHandler::save)
                .andRoute(DELETE("/user").and(accept(MediaType.APPLICATION_JSON)), userHandler::delete)
                .andRoute(PUT("/user").and(accept(MediaType.APPLICATION_JSON)), userHandler::update);
    }
}
