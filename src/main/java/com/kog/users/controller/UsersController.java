package com.kog.users.controller;


import com.kog.users.dto.UsersDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    WebClient.Builder webClient=WebClient.builder();


   /* RestTemplate restTemplate=new RestTemplate();

    @GetMapping("/displayUsers")
    @CircuitBreaker(name ="usersService" ,fallbackMethod = "getFallbackData")
    public List<UsersDto> getAllUsers(){
        return restTemplate.getForObject("http://localhost:8091/auth/allUsers", ArrayList.class);
    } */

    @GetMapping("/displayUsers")
    @CircuitBreaker(name ="usersService" ,fallbackMethod = "getFallbackData")
    public List<UsersDto> getAllUsers() {
        Flux<UsersDto> userFlux = webClient.build()
                .get()
                .uri("http://localhost:8092/auth/allUsers")
                .retrieve()
                .bodyToFlux(UsersDto.class);

        return userFlux.collectList().block();
    }
    public List<UsersDto> getFallbackData (Exception e){
        return Collections.emptyList();
    }
}


