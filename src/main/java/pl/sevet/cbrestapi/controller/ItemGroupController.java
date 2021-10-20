package pl.sevet.cbrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sevet.cbrestapi.dto.ItemGroupDto;
import pl.sevet.cbrestapi.service.ItemGroupService;

import java.util.List;

@RestController
@RequestMapping("/itemGroup")
public class ItemGroupController {
    //TODO dodać bool haveExpDate do grupy

    private final ItemGroupService groupService;

    @Autowired
    public ItemGroupController(ItemGroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemGroupDto>> getItemTypes() {
        return ResponseEntity.ok(groupService.getAll());
    }


    @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Long create(@RequestBody ItemGroupDto itemGroupDto) {
        return groupService.create(itemGroupDto);
    }
}
