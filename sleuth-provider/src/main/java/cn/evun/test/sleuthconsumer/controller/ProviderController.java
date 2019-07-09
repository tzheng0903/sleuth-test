package cn.evun.test.sleuthconsumer.controller;

import brave.propagation.ExtraFieldPropagation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@RestController
public class ProviderController {
    private static final Logger log = LoggerFactory.getLogger(ProviderController.class);

    @GetMapping("/sayHello")
    public String helloByFeign(String name, ServletRequest request){
        log.info("sayHello 方法执行。。。。。。。");
        log.info("ssessionid:" + ((HttpServletRequest)request).getSession().getId());
        log.info("sessinoid x" + ExtraFieldPropagation.get("SessionId"));
        return "hello :" + name;
    }

}
