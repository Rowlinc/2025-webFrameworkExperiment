package com.morgan.backendexamples.component.interceptor;

import com.morgan.backendexamples.POJO.DO.UserBackendExamples;
import com.morgan.backendexamples.component.Code;
import com.morgan.backendexamples.component.exception.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String role=request.getAttribute("role").toString();
        if (role.equals(UserBackendExamples.ROLE_ADMIN)){
            return true;
        }
        throw BusinessException.builder()
                .code(Code.BUSINESS_TOKEN_NOT_ADMIN).build();
    }
}
