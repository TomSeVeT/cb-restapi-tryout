package pl.sevet.cbrestapi.service;

import pl.sevet.cbrestapi.dto.HistoryItemDto;

import java.util.List;

public interface TransactionHistoryService {
    List<HistoryItemDto> getAll();

    List<HistoryItemDto> getUsage();
}
