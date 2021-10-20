package pl.sevet.cbrestapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sevet.cbrestapi.dto.HistoryItemDto;
import pl.sevet.cbrestapi.dto.HistoryTransactionDto;
import pl.sevet.cbrestapi.model.Transaction;
import pl.sevet.cbrestapi.model.TransactionType;
import pl.sevet.cbrestapi.repository.ItemRepository;
import pl.sevet.cbrestapi.repository.ItemTypeRepository;
import pl.sevet.cbrestapi.repository.TransactionRepository;
import pl.sevet.cbrestapi.service.TransactionHistoryService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService {

    TransactionRepository transactionRepository;
    ItemRepository itemRepository;


    public TransactionHistoryServiceImpl(TransactionRepository transactionRepository, ItemRepository itemRepository) {
        this.transactionRepository = transactionRepository;
        this.itemRepository = itemRepository;
    }

    @Autowired


    @Override
    public List<HistoryItemDto> getAll() {
     return null;//todo implement getallhistory
    }

    @Override
    public List<HistoryItemDto> getUsage() {
        List<HistoryItemDto> historyList = new ArrayList<>();
        itemRepository.findAll().forEach(x->{
            historyList.add( new HistoryItemDto(x.getId(),x.getTypeId(),x.getExpDate(),x.getCreationDate(), new ArrayList<>()));
        });

        List<Transaction> lista =transactionRepository.findAllByTransactionType(TransactionType.USE);
        lista.forEach(x->{
                    for (HistoryItemDto historyItemDto : historyList) {
                        if(historyItemDto.getItemId().equals(x.getItemId())){
                            historyItemDto.getTransactions().add(
                                    new HistoryTransactionDto(
                                            TransactionType.USE,
                                            x.getUserId(),
                                            x.getBeforeQuantity(),
                                            x.getAfterQuantity(),
                                            x.getBeforeLocationId(),
                                            x.getAfterLocationId(),
                                            x.getTransactionDate()
                                    )
                            );
                            break;
                        }
                    }
                });
        historyList.removeIf(x->x.getTransactions().isEmpty());
        return historyList;
    }
}
