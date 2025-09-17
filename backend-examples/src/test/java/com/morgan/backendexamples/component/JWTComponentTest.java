package com.morgan.backendexamples.component;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@Slf4j
@SpringBootTest
class JWTComponentTest {

    @Autowired
    private JWTComponent jwtComponent;
    @Test
    void encode() {
        String token=jwtComponent.encode(Map.of("uid","1417155381944340480","role","ADMIN"));
        System.out.println("\n\n"+token);
    }

    @Test
    void decode() {
    }

    @Test
    void getData() {
    }
}