package pl.sevet.cbrestapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sevet.cbrestapi.model.Transaction;
import pl.sevet.cbrestapi.model.TransactionType;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    List<Transaction> findAllByTransactionType(TransactionType transactionType);
}
