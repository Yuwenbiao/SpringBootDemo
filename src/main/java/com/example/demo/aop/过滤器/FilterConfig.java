package com.example.demo.aop.过滤器;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 过滤器配置
 * 需要配置的选项主要包括实例化Filter类，然后指定url的匹配模式，设置过滤器名称和执行顺序，
 * 这个过程和在web.xml中配置其实没什么区别，只是形式不同而已。
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
