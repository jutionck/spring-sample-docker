package com.enigmacamp.springsampledocker.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class IdGenerator {
    public String random() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
