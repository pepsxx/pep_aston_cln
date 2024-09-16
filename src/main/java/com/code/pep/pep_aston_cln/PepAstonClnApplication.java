package com.code.pep.pep_aston_cln;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PepAstonClnApplication {

    public static void main(String[] args) {
        SpringApplication.run(PepAstonClnApplication.class, args);

        System.out.println("PepAstonClnApplication started");

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/api/v1/bank_account/report"; // ваш URL

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Successful request:");
            System.out.println(response.getBody());
        } else {
            System.out.println("Error while sending the request.");
        }

        System.out.println("PepAstonClnApplication ended");
    }

}
