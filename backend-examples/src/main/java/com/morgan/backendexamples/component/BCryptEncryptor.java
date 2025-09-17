package com.morgan.backendexamples.component;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class BCryptEncryptor {
    public String encrypt(String password){
        return BCrypt.hashpw(password,BCrypt.gensalt());
    }

    public boolean isMatch(String password,String encryptedPassword){
        return BCrypt.checkpw(password,encryptedPassword);
    }
}
