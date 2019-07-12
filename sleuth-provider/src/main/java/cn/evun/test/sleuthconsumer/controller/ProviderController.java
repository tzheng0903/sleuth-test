package cn.evun.test.sleuthconsumer.controller;

import brave.propagation.ExtraFieldPropagation;
import cn.evun.test.sleuth.api.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProviderController implements HelloService {
    private static final Logger log = LoggerFactory.getLogger(ProviderController.class);

    public String sayHello(String name){
        log.info("sessinoid x" + ExtraFieldPropagation.get("SessionId"));
        return "hello :" + name;
    }

}
