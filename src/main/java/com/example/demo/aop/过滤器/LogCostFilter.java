package com.example.demo.aop.过滤器;

import javax.servlet.*;
import java.io.IOException;

/**
 * 通过过滤器来实现记录请求执行时间的功能（通过FilterRegistrationBean完成配置，即FilterConfig）
 *
 * @author yuwb@corp.21cn.com
 * @date 2019/8/3 17:38
 */
public class LogCostFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Execute cost=" + (System.currentTimeMillis() - start));
    }

    @Override
    public void destroy() {
    }
}
