package com.code.pep.pep_aston_cln.service.impl;

import com.code.pep.pep_aston_cln.dto.BankAccountDto;
import com.code.pep.pep_aston_cln.mapper.BankAccountMapper;
import com.code.pep.pep_aston_cln.repository.BankAccountRepository;
import com.code.pep.pep_aston_cln.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;
    private final BankAccountMapper bankAccountMapper;

    @Override
    @SneakyThrows
    public void saveAllBankAccountInDB() {

        final String URL = "http://localhost:8080/api/v1/bank_account/report";

        Optional.of(new RestTemplate().exchange(
                        URL,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<BankAccountDto>>() {
                        })
                )
                .filter(r -> r.getStatusCode() == HttpStatus.OK)
                .map(ResponseEntity::getBody)
                .filter(l -> !l.isEmpty())
                .map(bankAccountMapper::listBankAccountDtoToListBankAccount)
                .map(bankAccountRepository::saveAll)
                .ifPresentOrElse(
                        lb -> log.info("All Save Bank Account In DB: {}", lb),
                        () -> log.warn("Not Save Bank Account In DB")
                );

    }
}
