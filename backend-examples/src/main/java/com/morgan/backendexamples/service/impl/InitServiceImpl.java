package com.morgan.backendexamples.service.impl;

import com.morgan.backendexamples.POJO.DO.UserBackendExamples;
import com.morgan.backendexamples.component.BCryptEncryptor;
import com.morgan.backendexamples.repository.UserRepository;
import com.morgan.backendexamples.service.InitService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InitServiceImpl implements InitService {
    private final UserRepository userRepository;
    private final BCryptEncryptor bCryptEncryptor;

    @Value("${admin.account}")
    private String adminAccount;
    @Value("${admin.password}")
    private String adminPassword;

    @Transactional
    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void init(){
        long count=userRepository.count();
        if (count>0){
            return;
        }
        UserBackendExamples userBackendExamples = UserBackendExamples.builder()
                .account(adminAccount)
                .password(bCryptEncryptor.encrypt(adminPassword))
                .role(UserBackendExamples.ROLE_ADMIN)
                .build();
        userRepository.save(userBackendExamples);
    }
}
