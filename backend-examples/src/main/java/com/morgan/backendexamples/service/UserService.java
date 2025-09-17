package com.morgan.backendexamples.service;

import com.morgan.backendexamples.POJO.DO.UserBackendExamples;

import java.util.List;

public interface UserService {
    //    基于账号获取用户
    UserBackendExamples findByAccount(String account);

    //    基于uid获取用户
    UserBackendExamples findByUid(String id);

    //    基于id修改密码
    Integer updatePasswordById(UserBackendExamples user);

    //    获取所有用户
    List<UserBackendExamples> findAllUser();

    //    添加用户
    UserBackendExamples insertUser(UserBackendExamples user);
}
