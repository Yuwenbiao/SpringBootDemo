package com.example.demo.aop.拦截器;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用拦截器来记录请求的执行时间
 * 这里我们需要实现HandlerInterceptor这个接口，这个接口包括三个方法，preHandle是请求执行前执行的，
 * postHandler是请求结束执行的，但只有preHandle方法返回true的时候才会执行，afterCompletion是视图渲染完成后才执行，
 * 同样需要preHandle返回true，该方法通常用于清理资源等工作。除了实现上面的接口外，我们还需对其进行配置,见InterceptorConfig
 *
 * @author yuwb@corp.21cn.com
 * @date 2019/8/3 18:44
 */
public class LogCostInterceptor implements HandlerInterceptor {
    private long start = System.currentTimeMillis();

    /**
     * preHandle是请求执行前执行的
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) {
        start = System.currentTimeMillis();
        return true;
    }

    /**
     * postHandler是请求结束执行的
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {
        System.out.println("Interceptor cost=" + (System.currentTimeMillis() - start));
    }

    /**
     * afterCompletion是视图渲染完成后才执行，同样需要preHandle返回true，该方法通常用于清理资源等工作
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
    }
}
