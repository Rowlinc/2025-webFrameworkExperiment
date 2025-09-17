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

import java.util.Map;

@RestController
@RequestMapping("/api/example05")
@RequiredArgsConstructor
@CrossOrigin//支持跨域
public class UserController {
    private final JWTComponent jwtComponent;
    private final UserService userService;
    @PostMapping("/user/updatePassword")
    public Result updatePassword(@RequestBody String newPassword, HttpServletRequest request){
        Object tokenOb = request.getAttribute("token");
        if (tokenOb ==null){
            throw BusinessException.builder()
                    .code(Code.BUSINESS_TOKEN_INCORRECT).build();
        }
        String token=tokenOb.toString();
        String uid=jwtComponent.getData(token,"uid");
        Integer count=userService.updatePasswordById(UserBackendExamples.builder().id(uid).password(newPassword).build());
        return Result.success(Code.BUSINESS_SQL_UPDATE_PASSWORD_SUCCESS, Map.of("msg","修改条数:"+count));
    }
}
