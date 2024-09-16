package com.code.pep.pep_aston_cln.service;

/**
 * Сервис по работе с банковскими счетами
 */
public interface BankAccountService {

    /**
     * Записывает в db все текущие банковские счета с их текущим состоянием на момент записи
     */
    void saveAllBankAccountInDB();

}
