package com.example.demo.Speaker.configuration;

import com.example.demo.Speaker.domain.SpeakerDown;
import com.example.demo.Speaker.domain.SpeakerUp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpeakerConfiguration {
    private final Logger log = LoggerFactory.getLogger(SpeakerConfiguration.class);

    @Bean(value = "up", initMethod = "init", destroyMethod = "destroy")
    public SpeakerUp createSpeakerUp(){
        log.info("Call createSpeakerUp");
        return new SpeakerUp();
    }

    @Bean(value = "down", initMethod = "init", destroyMethod = "destroy")
    public SpeakerDown createSpeakerDown(){
        log.info("Call createSpeakerDown");
        return new SpeakerDown();
    }
}
