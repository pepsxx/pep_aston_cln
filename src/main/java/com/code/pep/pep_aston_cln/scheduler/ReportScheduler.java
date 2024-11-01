package com.code.pep.pep_aston_cln.scheduler;

import com.code.pep.pep_aston_cln.service.impl.BankAccountServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReportScheduler {

    private final BankAccountServiceImpl bankAccountService;

    @Scheduled(fixedRate = 10_000)
    public void saveAllBankAccountInDB() {

        log.info("Start to save bank account in db");

        try {

            bankAccountService.saveAllBankAccountInDB();

        } catch (Exception e) {

            log.error(e.getMessage());

        }

        log.info("Stop to save bank account in db");

    }
}
