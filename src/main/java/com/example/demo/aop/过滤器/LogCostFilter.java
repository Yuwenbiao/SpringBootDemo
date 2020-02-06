package com.example.demo.aop.过滤器;

import javax.servlet.*;
import java.io.IOException;

/**
 * 通过过滤器来实现记录请求执行时间的功能（通过FilterRegistrationBean完成配置，即FilterConfig）
 * 这段代码的逻辑比较简单，就是在方法执行前先记录时间戳，然后通过过滤器链完成请求的执行，在返回结果之间计算执行的时间。
 * 这个类必须继承Filter类，这个是Servlet的规范，这个跟以前的Web项目没区别。
 * 有了过滤器类以后，以前的web项目可以在web.xml中进行配置，在Spring boot中，我们需要FilterRegistrationBean来完成配置。
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
