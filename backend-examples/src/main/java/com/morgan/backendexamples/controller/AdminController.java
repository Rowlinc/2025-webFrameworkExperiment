package com.morgan.backendexamples.controller;

import com.morgan.backendexamples.POJO.DO.UserBackendExamples;
import com.morgan.backendexamples.POJO.VO.Result;
import com.morgan.backendexamples.component.Code;
import com.morgan.backendexamples.component.JWTComponent;
import com.morgan.backendexamples.component.exception.BusinessException;
import com.morgan.backendexamples.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/example05")
@RequiredArgsConstructor
@CrossOrigin//支持跨域
public class AdminController {
    private final JWTComponent jwtComponent;
    private final UserService userService;
//    检验令牌
    public void checkAdminToken(Object tokenOb){
        if (tokenOb==null){
            throw BusinessException.builder()
                    .code(Code.BUSINESS_TOKEN_INCORRECT).build();
        }
        String token=tokenOb.toString();
        String role=jwtComponent.getData(token,"role");
        if (!role.equals(UserBackendExamples.ROLE_ADMIN)){
            throw BusinessException.builder()
                    .code(Code.BUSINESS_TOKEN_NOT_ADMIN).build();
        }
    }
//    添加用户
    @PostMapping("/admin/insertUser")
    public Result insertUser(@RequestBody UserBackendExamples user, HttpServletRequest request){
        Object tokenOb =request.getAttribute("token");
        checkAdminToken(tokenOb);
        user.setRole(null);
        UserBackendExamples newUser =userService.insertUser(user);
        return Result.success(Code.BUSINESS_SQL_INSERT_USER_SUCCESS,newUser);
    }
//    获取全部用户信息
    @GetMapping("/admin/getAllUser")
    public Result getAllUser(HttpServletRequest request){
        Object tokenOb =request.getAttribute("token");
        checkAdminToken(tokenOb);
        List<UserBackendExamples> users =userService.findAllUser();
        return Result.success(Code.BUSINESS_SQL_GET_ALL_USER_SUCCESS,users);
    }
//    重置指定账号密码
    @PostMapping("/admin/rebuildPassword")
    public Result rebuildPassword(@RequestBody UserBackendExamples user, HttpServletRequest request){
        Object tokenOb=request.getAttribute("token");
        checkAdminToken(tokenOb);
        user.setPassword(null);
        Integer changeCount=userService.updatePasswordById(user);
        return Result.success(Code.BUSINESS_SQL_UPDATE_PASSWORD_SUCCESS, Map.of("msg","修改条目数为:"+changeCount));
    }
}
