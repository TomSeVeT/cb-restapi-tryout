package pl.sevet.cbrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sevet.cbrestapi.dto.HistoryItemDto;
import pl.sevet.cbrestapi.service.TransactionHistoryService;

import java.util.List;

@RestController
@RequestMapping("/transaction/history")
public class TransactionHistoryController {

    TransactionHistoryService historyService;

    @Autowired
    public TransactionHistoryController(TransactionHistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping(path = "/usage", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HistoryItemDto> getUsage() { return historyService.getUsage(); }

    @GetMapping(path = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HistoryItemDto> getAll() { return historyService.getAll(); }
}
