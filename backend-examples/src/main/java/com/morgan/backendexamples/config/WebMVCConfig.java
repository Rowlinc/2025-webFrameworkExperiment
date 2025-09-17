package com.morgan.backendexamples.config;

import com.morgan.backendexamples.component.interceptor.AdminInterceptor;
import com.morgan.backendexamples.component.interceptor.LoginInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMVCConfig implements WebMvcConfigurer {
    private final LoginInterceptor loginInterceptor;
    private final AdminInterceptor adminInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("api/example05/**")
                .excludePathPatterns("/api/example05/login");
        registry.addInterceptor(adminInterceptor)
                .addPathPatterns("api/example05/admin/**");
    }
}
