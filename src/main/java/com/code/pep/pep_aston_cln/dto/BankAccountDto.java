package com.code.pep.pep_aston_cln.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class BankAccountDto {

    private BigDecimal money;

    private String name;

    private Long numberAccount;

}