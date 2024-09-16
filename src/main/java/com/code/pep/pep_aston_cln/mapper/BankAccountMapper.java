package com.code.pep.pep_aston_cln.mapper;

import com.code.pep.pep_aston_cln.dto.BankAccountDto;
import com.code.pep.pep_aston_cln.entity.BankAccount;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class BankAccountMapper {

    public BankAccount bankAccountDtoToBankAccount(BankAccountDto bankAccountDto) {

        return BankAccount.builder()
                .name(bankAccountDto.getName())
                .money(bankAccountDto.getMoney())
                .numberAccount(bankAccountDto.getNumberAccount())
                .timeAdding(LocalDateTime.now())
                .build();

    }

    public List<BankAccount> listBankAccountDtoToListBankAccount(List<BankAccountDto> listBankAccountDto) {

        return listBankAccountDto.stream()
                .map(this::bankAccountDtoToBankAccount)
                .toList();

    }
}
