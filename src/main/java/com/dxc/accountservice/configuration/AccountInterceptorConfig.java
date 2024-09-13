package com.dxc.accountservice.configuration;

import com.dxc.accountservice.interceptors.AccountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Component
public class AccountInterceptorConfig implements WebMvcConfigurer {

//    @Autowired
//    private AccountInterceptor accountInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(accountInterceptor).addPathPatterns("/account/**");
//    }
}
