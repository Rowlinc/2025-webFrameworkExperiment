package com.morgan.backendexamples.controller;

import com.morgan.backendexamples.POJO.DO.UserBackendExamples;
import com.morgan.backendexamples.POJO.VO.Result;
import com.morgan.backendexamples.component.BCryptEncryptor;
import com.morgan.backendexamples.component.Code;
import com.morgan.backendexamples.component.JWTComponent;
import com.morgan.backendexamples.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/example05")
@RequiredArgsConstructor
public class LoginController {
    private final BCryptEncryptor bCryptEncryptor;
    private final UserService userService;
    private final JWTComponent jwtComponent;
    @PostMapping("/login")
    public Result basicLogin(@RequestBody UserBackendExamples userBackendExamples, HttpServletResponse response){
        UserBackendExamples user=userService.findByAccount(userBackendExamples.getAccount());
        if (user==null||!bCryptEncryptor.isMatch(userBackendExamples.getPassword(), user.getPassword())){
            return Result.error(Code.BUSINESS_PASSWORD_ERROR);
        }
        String token=jwtComponent.encode(Map.of("uid",user.getId(),"role",user.getRole()));
        response.addHeader("token",token);
        return Result.success(Code.BUSINESS_LOGIN_SUCCESS, user);
    }
    @GetMapping("/admin/welcome")
    public Result adminLogin(@RequestAttribute("role") String role){
        log.debug(role);
        return Result.success(Code.BUSINESS_TOKEN_IS_ADMIN, Map.of("msg","管理员登录成功"));
    }
}
