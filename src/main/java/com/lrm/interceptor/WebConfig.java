package com.lrm.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wu
 * @date 2022-01-17 14:34
 * 配置拦截器需要拦截那些路径
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())//拦截器注册到容器中
                .addPathPatterns("/admin/**")  //需要拦截admin下的所有
                .excludePathPatterns("/admin", "/admin/login"); //放行的请求
    }
}
