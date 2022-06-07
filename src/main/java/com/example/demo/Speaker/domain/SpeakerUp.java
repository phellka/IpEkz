package com.example.demo.Speaker.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpeakerUp implements Speaker{
    private final Logger log = LoggerFactory.getLogger(SpeakerUp.class);

    @Override
    public String say() {
        return "ПРИВЕТ";
    }
    public void init() {
        log.info("SpeakerUp.init()");
    }

    public void destroy() {
        log.info("SpeakerUp.destroy()");
    }
}
