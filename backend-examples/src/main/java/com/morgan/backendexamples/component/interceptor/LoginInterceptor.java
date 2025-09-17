package com.morgan.backendexamples.component.interceptor;

import com.morgan.backendexamples.component.Code;
import com.morgan.backendexamples.component.JWTComponent;
import com.morgan.backendexamples.component.exception.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {
    private final JWTComponent jwtComponent;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token=request.getHeader("token");
        if (token==null){
            throw BusinessException.builder()
                    .code(Code.BUSINESS_TOKEN_INCORRECT).build();
        }
        String uid=jwtComponent.getData(token,"uid");
        String role=jwtComponent.getData(token,"role");
        request.setAttribute("uid",uid);
        request.setAttribute("role",role);
        return true;
    }
}
