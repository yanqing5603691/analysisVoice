/*
package com.config;

import org.omg.PortableInterceptor.Interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Component
public class WavConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandles(ResourceHandlerRegistry registry){
        registry.addResourceHandler("classpath:*//*
voice*/
/*.wav");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new LicenseCheckIntercepter()).addPathPatterns("*//*
voice*/
/*.wav");
    }
    public class LicenseCheckIntercepter implements HandlerInterceptor {
    }


}
*/
