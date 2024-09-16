package com.code.pep.pep_aston_cln;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PepAstonClnApplication {

    public static void main(String[] args) {

        SpringApplication.run(PepAstonClnApplication.class, args);

    }

}
