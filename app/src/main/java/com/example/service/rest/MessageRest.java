package com.example.service.rest;

import com.example.service.Message;
import com.example.service.MessageApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRest implements MessageApi {

    @Autowired
    private Environment environment;

    @Override
    public Message message() {
        return new Message()
            .setValue(environment.getActiveProfiles());
    }

}
