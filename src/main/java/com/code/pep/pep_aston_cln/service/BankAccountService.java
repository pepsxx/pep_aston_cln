package com.code.pep.pep_aston_cln.service;

import com.code.pep.pep_aston_cln.dto.BankAccountDto;
import com.code.pep.pep_aston_cln.entity.BankAccount;
import com.code.pep.pep_aston_cln.mapper.BankAccountMapper;
import com.code.pep.pep_aston_cln.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;
    private final BankAccountMapper bankAccountMapper;


    public void saveAllBankAccountInDB() {

        final String URL = "http://localhost:8080/api/v1/bank_account/report";

        List<BankAccount> bankAccountList = Optional.ofNullable(new RestTemplate().exchange(
                                URL,
                                HttpMethod.GET,
                                null,
                                new ParameterizedTypeReference<List<BankAccountDto>>() {
                                })
                        .getBody())
                .map(bankAccountMapper::listBankAccountDtoToListBankAccount)
                .map(bankAccountRepository::saveAll)
                .orElseThrow(RuntimeException::new);

        log.info("Bank accounts saved {}", bankAccountList);

    }

}
