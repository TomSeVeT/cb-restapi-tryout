package pl.sevet.cbrestapi.dto;

import java.util.ArrayList;
import java.util.Date;

public class HistoryItemDto {
    private Long itemId;
    private Long itemTypeId;
    private Date expDate;
    private Date creationDate;
    private ArrayList<HistoryTransactionDto> transactions;

    public HistoryItemDto() {
    }

    public HistoryItemDto(Long itemId, Long itemTypeId, Date expDate, Date creationDate, ArrayList<HistoryTransactionDto> transactions) {
        this.itemId = itemId;
        this.itemTypeId = itemTypeId;
        this.expDate = expDate;
        this.creationDate = creationDate;
        this.transactions = transactions;
    }

    public HistoryItemDto(Long itemId, Long itemTypeId, Date expDate, Date creationDate) {
        this.itemId = itemId;
        this.itemTypeId = itemTypeId;
        this.expDate = expDate;
        this.creationDate = creationDate;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(Long itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public ArrayList<HistoryTransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<HistoryTransactionDto> transactions) {
        this.transactions = transactions;
    }
}
