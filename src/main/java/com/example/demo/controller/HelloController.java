package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

/**
 * AOP测试类
 *
 * @author yuwb@corp.21cn.com
 * @date 2019/8/3 16:41
 */
@RestController
public class HelloController {
    /**
     * 打印Hello
     *
     * @param name 姓名
     * @return 返回Hello 姓名
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam String name) {
        System.out.println("hello " + name);
        return "Hello " + name;
    }
}
