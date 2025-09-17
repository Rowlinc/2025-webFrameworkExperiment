package com.morgan.backendexamples.component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.morgan.backendexamples.component.exception.BusinessException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

@Component
public class JWTComponent {
    // 私钥
    @Value("${my.secretKey}")
    private String secretKey;
    private Algorithm algorithm;
    // 组件初始化后，初始化加密算法对象。无需反复创建
    @PostConstruct
    private void init() {
        algorithm = Algorithm.HMAC256(secretKey);
    }
    public String encode(Map<String, Object> map) {
        // 1天后过期
        LocalDateTime time = LocalDateTime.now().plusDays(1);
        return JWT.create()
                .withPayload(map)
                .withIssuedAt(new Date())
                .withExpiresAt(Date.from(time.atZone(ZoneId.systemDefault()).toInstant()))
                .sign(algorithm);
    }

    public DecodedJWT decode(String token) {
        try {
            return JWT.require(algorithm).build().verify(token);
        } catch (TokenExpiredException | SignatureVerificationException | JWTDecodeException e) {
            if (e instanceof SignatureVerificationException || e instanceof JWTDecodeException) {
                throw BusinessException.builder().code(Code.BUSINESS_TOKEN_INCORRECT).build();
            }
            throw BusinessException.builder().code(Code.BUSINESS_TOKEN_EXPIRED).build();
        }
    }
    public String getData(String token,String key){
        DecodedJWT decodedJWT=decode(token);
        return decodedJWT.getClaim(key).asString();
    }
}