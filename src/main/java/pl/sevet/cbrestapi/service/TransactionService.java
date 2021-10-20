package pl.sevet.cbrestapi.service;

import pl.sevet.cbrestapi.dto.TransactionDto;

import java.util.List;

public interface TransactionService {
    void create(TransactionDto transactionDto);

    void make(TransactionDto transactionDto);

    void delivery(List<TransactionDto> transactions);

    void move(List<TransactionDto> transactions);

    void use(List<TransactionDto> transactions);
}
