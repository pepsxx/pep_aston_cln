package com.code.pep.pep_aston_cln.schedulers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestScheduler {

    @Scheduled(fixedRate = 10_000)
    public void logMessage() {
        log.info("Привет!");
    }
}
