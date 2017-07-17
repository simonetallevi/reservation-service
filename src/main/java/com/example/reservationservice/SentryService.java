package com.example.reservationservice;

import io.sentry.Sentry;
import io.sentry.SentryClient;
import io.sentry.event.EventBuilder;
import io.sentry.event.helper.EventBuilderHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.PostLoad;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Created by tallesi001 on 17/07/17.
 */
@Service
public class SentryService {

    @Value("${sentry.tags}")
    private String tags;
    @Value("${sentry.dsn}")
    private String dsn;


    @PostConstruct
    private void init(){

        String[] tt = tags.split(",");
        Sentry.init(dsn);

        SentryClient client = Sentry.getStoredClient();
        EventBuilderHelper myEventBuilderHelper;
        myEventBuilderHelper = eventBuilder -> Arrays.stream(tt).forEach(s -> {
            String[] t = s.split(":");
            eventBuilder.withTag(t[0], t[1]);
        });
        client.addBuilderHelper(myEventBuilderHelper);
    }

    @PreDestroy
    private void destroy(){
        Sentry.getStoredClient().closeConnection();
    }
}
