package com.example.demo.aop.拦截器;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 拦截器配置
 * 这里我们继承了WebMVCConfigurerAdapter，重写了addInterceptors这个方法，进行拦截器的配置，
 * 主要配置项就两个，一个是指定拦截器，第二个是指定拦截的URL。
 *
 * @author yuwb@corp.21cn.com
 * @date 2019/8/3 18:54
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogCostInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
