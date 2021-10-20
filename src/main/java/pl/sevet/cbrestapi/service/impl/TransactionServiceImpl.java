package pl.sevet.cbrestapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sevet.cbrestapi.dto.TransactionDto;
import pl.sevet.cbrestapi.model.Item;
import pl.sevet.cbrestapi.model.Transaction;
import pl.sevet.cbrestapi.model.TransactionType;
import pl.sevet.cbrestapi.repository.ItemRepository;
import pl.sevet.cbrestapi.repository.TransactionRepository;
import pl.sevet.cbrestapi.service.TransactionService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final ItemRepository itemRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(ItemRepository itemRepository, TransactionRepository transactionRepository) {
        this.itemRepository = itemRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void create(TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setTransactionType(TransactionType.CREATE);
        transaction.setItemId(transaction.getItemId());
        transaction.setBeforeLocationId(-1L);
        transaction.setAfterLocationId(transaction.getAfterLocationId());
        transaction.setBeforeQuantity(-1L);
        transaction.setAfterQuantity(transactionDto.getAfterQuantity());
        transaction.setUserId(transactionDto.getUserId());
        transaction.setTransactionDate(new Date());
        transactionRepository.save(transaction);
    }

    @Override
    public void make(TransactionDto transactionDto) {
        Item oldItem = itemRepository.findById(transactionDto.getItemId()).get();

        Transaction transaction = new Transaction();

        transaction.setItemId(transaction.getItemId());
        transaction.setBeforeLocationId(oldItem.getLocationId());
        transaction.setAfterLocationId(transaction.getAfterLocationId());
        transaction.setBeforeQuantity(oldItem.getQuantity());
        transaction.setAfterQuantity(transactionDto.getAfterQuantity());
        transaction.setUserId(transactionDto.getUserId());
        transaction.setTransactionDate(new Date());

        if (Float.compare(oldItem.getQuantity(), transaction.getAfterQuantity()) < 0) {
            transaction.setTransactionType(TransactionType.ADD);
            oldItem.setQuantity(transactionDto.getAfterQuantity());
        } else if (Float.compare(oldItem.getQuantity(), transaction.getAfterQuantity()) > 0) {
            transaction.setTransactionType(TransactionType.USE);
            oldItem.setQuantity(transactionDto.getAfterQuantity());
        } else if (!oldItem.getLocationId().equals(transaction.getAfterLocationId())) {
            transaction.setTransactionType(TransactionType.MOVE);
            oldItem.setLocationId(transactionDto.getAfterLocationId());
        } else
            transaction.setTransactionType(TransactionType.TRASH);


        transactionRepository.save(transaction);
        itemRepository.save(oldItem);
    }

    @Override
    public void delivery(List<TransactionDto> transactions) {
        for(TransactionDto transactionDto
                    :transactions){
            Item newItem = itemRepository.save(new Item(
                    "Po dostawie",
                    transactionDto.getAfterQuantity(),
                    transactionDto.getItemTypeId(),
                    transactionDto.getAfterLocationId(),
                    transactionDto.getExpDate(),
                    transactionDto.getTransactionDate()
            ));
            saveTransactionHistory(transactionDto, newItem.getId());
        }
    }

    @Override
    public void move(List<TransactionDto> transactions) {
        for(TransactionDto transactionDto
                :transactions){
            Optional<Item> itemToChange = itemRepository.findById(transactionDto.getItemId());
            itemToChange.ifPresent(item -> {
                item.setLocationId(transactionDto.getAfterLocationId());
                itemRepository.save(item);
                saveTransactionHistory(transactionDto, transactionDto.getItemId());
            });

        }
    }

    @Override
    public void use(List<TransactionDto> transactions) {
        for(TransactionDto transactionDto
                :transactions){
            Optional<Item> itemToChange = itemRepository.findById(transactionDto.getItemId());
            if(itemToChange.isPresent()){
                itemToChange.get().setQuantity(transactionDto.getAfterQuantity());
                itemRepository.save(itemToChange.get());
                saveTransactionHistory(transactionDto, transactionDto.getItemId());
            }
        }
    }

    private void saveTransactionHistory(TransactionDto transactionDto, Long itemId) {
        transactionRepository.save(new Transaction(
                transactionDto.getTransactionType(),
                itemId,
                transactionDto.getBeforeLocationId(),
                transactionDto.getAfterLocationId(),
                transactionDto.getBeforeQuantity(),
                transactionDto.getAfterQuantity(),
                transactionDto.getUserId(),
                transactionDto.getTransactionDate()
        ));
    }
}
