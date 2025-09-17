package com.morgan.backendexamples.service.impl;

import com.morgan.backendexamples.POJO.DO.UserBackendExamples;
import com.morgan.backendexamples.component.BCryptEncryptor;
import com.morgan.backendexamples.component.Code;
import com.morgan.backendexamples.component.exception.BusinessException;
import com.morgan.backendexamples.repository.UserRepository;
import com.morgan.backendexamples.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptEncryptor bCryptEncryptor;
    @Value("${my.default-password}")
    private String defaultPassword;
    //    基于账号获取用户
    @Override
    public UserBackendExamples findByAccount(String account){
            UserBackendExamples user = userRepository.findByAccount(account);
            if (user == null){
                throw BusinessException.builder().code(Code.BUSINESS_SQL_NODATA).build();
            }
            return user;
    }
    //    基于uid获取用户
    @Override
    public UserBackendExamples findByUid(String id){
            UserBackendExamples user = userRepository.findById(id).orElse(null);
            if (user==null){
                throw BusinessException.builder().code(Code.BUSINESS_SQL_NODATA).build();
            }
            return user;
    }
    //    基于id修改密码
    @Override
    public Integer updatePasswordById(UserBackendExamples user){
            String password=user.getPassword();
            if (password==null){
                password=defaultPassword;
            }
            user.setPassword(bCryptEncryptor.encrypt(password));
            int changeCount = userRepository.updatePasswordById(user);
            if(changeCount ==0){
                throw BusinessException.builder().code(Code.BUSINESS_SQL_FAIL_TO_UPDATE).build();
            }
            return changeCount;
    }
    //    获取所有用户
    @Override
    public List<UserBackendExamples> findAllUser() {
        List<UserBackendExamples> users = userRepository.findAllUser();
        if (users.isEmpty()) {
            throw BusinessException.builder().code(Code.BUSINESS_SQL_TABLE_EMPTY).build();
        }
        return users;
    }

//    添加用户
    @Override
    public UserBackendExamples insertUser(UserBackendExamples user){
        if (user.getRole()==null)user.setRole(UserBackendExamples.ROLE_USER);
        String password=user.getPassword();
        user.setPassword(bCryptEncryptor.encrypt(password));
        return userRepository.save(user);
    }
}
