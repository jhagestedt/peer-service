package com.example.service;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

public interface MessageApi {

    @GetMapping(
        path = "/api/message",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    Message message();

}
