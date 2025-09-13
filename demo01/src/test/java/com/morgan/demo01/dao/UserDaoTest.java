package com.morgan.demo01.dao;

import com.morgan.demo01.entity.DO.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UserDaoTest {
    @Autowired
    private UserDao userDao;

//    改
    @Test
    void updateTest(){
        var user=User.builder()
                .id("1416323881434828800")
                .name("wang")
                .build();
        userDao.save(user);
    }

//    增
    @Test
    void saveTest(){
        var user= User.builder()
                .name("song")
                .build();
        userDao.save(user);
    }

//    查
    @Test
    void findTest(){
        userDao.findById("1416323881434828800");
    }
//    删除
    @Test
    void deleteTest(){
        userDao.deleteById("1416323881434828800");
    }
//    增多条
    @Test
    void saveAllTest(){
        List<User> users= Stream.of(
                User.builder().name("01").build(),
                User.builder().name("02").build(),
                User.builder().name("03").build()
        ).toList();
        userDao.saveAll(users);
    }

}