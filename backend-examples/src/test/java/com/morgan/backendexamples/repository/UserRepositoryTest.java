package com.morgan.backendexamples.repository;

import com.morgan.backendexamples.POJO.DO.UserBackendExamples;
import com.morgan.backendexamples.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class UserRepositoryTest {
    @Autowired
    private UserService userService;

    @Test
    public void getByAccountTest(){
        System.out.println(userService.findByAccount("admin"));
    }
    @Test
    public void updatePasswordByIdTest(){
    }
    @Test
    public void insertUserTest(){
        System.out.println(userService.insertUser(UserBackendExamples.builder().account("song").password("song").build()));
    }
}