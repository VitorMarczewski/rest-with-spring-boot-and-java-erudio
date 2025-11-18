package com.github.VitorMarczewski.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //serve para receber requisicoes https
public class TestLogController {

    private static final Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());

    @GetMapping("/test") // controla requisicoes a partir de /test
    public String testLog(){
        logger.info("log em nivel INFO");
        logger.warn("log em nivel WARN");
        logger.debug("log em nivel DEBUG");
        logger.trace("log em nivel TRACE");
        logger.error("log em nivel ERROR");
        return "Logs gerados com sucesso";
    }

}
