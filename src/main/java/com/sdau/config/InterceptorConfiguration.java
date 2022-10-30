package com.sdau.config;


import com.sdau.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/*配置类*/
@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public LoginInterceptor getLoginInterceptor(){
        return new LoginInterceptor();
    }

    /*添加拦截器*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        List<String> list = new ArrayList<String>();
        /*拦截staff*/
        list.add("/staff/*");
        /*拦截vip*/
        list.add("/vip/*");
        /*拦截room*/
        list.add("/room/*");
        registry.addInterceptor(getLoginInterceptor()).addPathPatterns(list);

    }
}
