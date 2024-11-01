package com.code.pep.pep_aston_cln.service.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;

import java.net.URI;

@Configuration
public class BankAccountServiceConfig {

    @Value("${service.bank_account.host}")
    private String url;

    @Bean
    public RequestEntity<Void> requestEntityForBankAccountMethodGet() {

        return new RequestEntity<>(HttpMethod.GET, URI.create(url));

    }

}
