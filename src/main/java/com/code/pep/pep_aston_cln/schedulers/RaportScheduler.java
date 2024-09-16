package com.code.pep.pep_aston_cln.schedulers;

import com.code.pep.pep_aston_cln.dto.BankAccountDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Component
public class RaportScheduler {

    private static final String URL = "http://localhost:8080/api/v1/bank_account/report";

    @Scheduled(fixedRate = 1_000)
    public void logMessage() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List> response = restTemplate.getForEntity(URL, List.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            List<BankAccountDto> listBankAccountDto = (List<BankAccountDto>) response.getBody();
            System.out.println("listBankAccountDto = " + listBankAccountDto);
        } else {
            System.out.println("Error while sending the request.");
        }
    }
}
