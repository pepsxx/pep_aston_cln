package com.code.pep.pep_aston_cln.mapper;

import com.code.pep.pep_aston_cln.dto.BankAccountDto;
import com.code.pep.pep_aston_cln.entity.BankAccount;

import java.util.List;

/**
 * Маппер для BankAccount
 */
public interface BankAccountMapper {
    BankAccount bankAccountDtoToBankAccount(BankAccountDto bankAccountDto);

    /**
     * Маппер из List BankAccountDto в List BankAccount
     */
    List<BankAccount> listBankAccountDtoToListBankAccount(List<BankAccountDto> listBankAccountDto);

}
