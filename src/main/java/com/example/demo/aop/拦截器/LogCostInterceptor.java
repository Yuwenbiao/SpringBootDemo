package com.example.demo.aop.拦截器;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用拦截器来记录请求的执行时间
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
