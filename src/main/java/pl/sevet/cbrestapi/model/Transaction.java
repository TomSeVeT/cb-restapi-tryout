package pl.sevet.cbrestapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TransactionType transactionType;
    private Long itemId;
    private Long beforeLocationId;
    private Long afterLocationId;
    private float beforeQuantity;
    private float afterQuantity;
    private Long userId;
    private Date transactionDate;

    public Transaction() {
    }


    public Transaction(TransactionType transactionType, Long itemId, Long beforeLocationId, Long afterLocationId,
                       float beforeQuantity, float afterQuantity, Long userId, Date transactionDate) {
        this.transactionType = transactionType;
        this.itemId = itemId;
        this.beforeLocationId = beforeLocationId;
        this.afterLocationId = afterLocationId;
        this.beforeQuantity = beforeQuantity;
        this.afterQuantity = afterQuantity;
        this.userId = userId;
        this.transactionDate = transactionDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getBeforeLocationId() {
        return beforeLocationId;
    }

    public void setBeforeLocationId(Long beforeLocationId) {
        this.beforeLocationId = beforeLocationId;
    }

    public Long getAfterLocationId() {
        return afterLocationId;
    }

    public void setAfterLocationId(Long afterLocationId) {
        this.afterLocationId = afterLocationId;
    }

    public float getBeforeQuantity() {
        return beforeQuantity;
    }

    public void setBeforeQuantity(float beforeQuantity) {
        this.beforeQuantity = beforeQuantity;
    }

    public float getAfterQuantity() {
        return afterQuantity;
    }

    public void setAfterQuantity(float afterQuantity) {
        this.afterQuantity = afterQuantity;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
