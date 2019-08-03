package com.example.demo.aop.过滤器;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 过滤器配置
 *
 * @author yuwb@corp.21cn.com
 * @date 2019/8/3 17:40
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<LogCostFilter> registerFilter() {
        FilterRegistrationBean<LogCostFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new LogCostFilter());
        registration.addUrlPatterns("/*");
        registration.setName("LogCostFilter");
        registration.setOrder(1);
        return registration;
    }
}
