package com.example.reservationservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tallesi001 on 11/07/17.
 */
@Slf4j
@RestController
@RefreshScope
public class MessageRestController {

    @Value("${message}")
    private String message;

    @RequestMapping("/message")
    public String read(){
        log.error("message : {}", message);
        if(true)
            throw new IllegalStateException("ERORR");
        return this.message;
    }
}
