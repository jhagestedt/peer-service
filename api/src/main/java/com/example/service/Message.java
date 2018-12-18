package com.example.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {

    private String[] value;

    public Message setValue(String[] value) {
        this.value = value;
        return this;
    }
}
