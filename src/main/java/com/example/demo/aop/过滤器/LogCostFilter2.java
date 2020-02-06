package com.example.demo.aop.过滤器;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 通过过滤器来实现记录请求执行时间的功能（通过注解完成配置）
 * 除了通过 FilterRegistrationBean 来配置以外，还有一种更直接的办法，直接通过注解就可以完成了
 * 这里直接用@WebFilter就可以进行配置，同样，可以设置url匹配模式，过滤器名称等。
 * 这里需要注意一点的是@WebFilter这个注解是Servlet3.0的规范，并不是Spring boot提供的。
 * 除了这个注解以外，我们还需在配置类中加另外一个注解：@ServletComponetScan，指定扫描的包。
 * 注意：@WebFilter这个注解并没有指定执行顺序的属性，其执行顺序依赖于Filter的名称，
 * 是根据Filter类名（注意不是配置的filter的名字）的字母顺序倒序排列，
 * 并且@WebFilter指定的过滤器优先级都高于FilterRegistrationBean配置的过滤器。
 *
 * @author yuwb@corp.21cn.com
 * @date 2019/8/3 17:45
 */
@WebFilter(urlPatterns = "/*", filterName = "logFilter2")
public class LogCostFilter2 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("LogFilter2 Execute cost=" + (System.currentTimeMillis() - start));
    }

    @Override
    public void destroy() {
    }
}
