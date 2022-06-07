package com.example.demo.Speaker.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpeakerDown implements Speaker {
    private final Logger log = LoggerFactory.getLogger(SpeakerDown.class);

    @Override
    public String say() {
        return "привет";
    }
    public void init() {
        log.info("SpeakerDown.init()");
    }

    public void destroy() {
        log.info("SpeakerDown.destroy()");
    }
}
