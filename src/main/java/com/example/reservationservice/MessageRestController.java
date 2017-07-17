package com.example.reservationservice;

import io.sentry.Sentry;
import io.sentry.SentryClient;
import io.sentry.event.EventBuilder;
import io.sentry.event.UserBuilder;
import io.sentry.event.helper.EventBuilderHelper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
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
        MDC.put("test","test");
        log.error("message : {}", message);
        return this.message;
    }
}
