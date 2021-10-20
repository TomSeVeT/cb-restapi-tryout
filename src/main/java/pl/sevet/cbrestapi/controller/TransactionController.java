package pl.sevet.cbrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sevet.cbrestapi.dto.TransactionDto;
import pl.sevet.cbrestapi.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService service;

    @Autowired
    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping(path = "/delivery")
    public void delivery(@RequestBody List<TransactionDto> transactions){
        service.delivery(transactions);
    }

    @PostMapping("/create")
    public void create(@RequestBody TransactionDto transactions) {
        service.create(transactions);
    }

    @PostMapping("/move")
    public void move(@RequestBody List<TransactionDto> transactions){ service.move(transactions); }

    @PostMapping("/use")
    public void use(@RequestBody List<TransactionDto> transactions){ service.use(transactions); }

    @PostMapping
    public void make(@RequestBody TransactionDto transactions) {
        service.make(transactions);
    }
}
