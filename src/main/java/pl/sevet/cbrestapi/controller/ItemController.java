package pl.sevet.cbrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sevet.cbrestapi.dto.ItemDto;
import pl.sevet.cbrestapi.dto.ItemTypeDto;
import pl.sevet.cbrestapi.service.ItemService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(path = "/getTypes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemTypeDto>> getItemTypes() {
        return ResponseEntity.ok(itemService.getAllTypes());
    }

    @GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemDto>> getAll() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @GetMapping(path = "/getAllByLocationId")
    public ResponseEntity<List<ItemDto>> getAllByLocationId(@RequestParam Long locationId) {
        return ResponseEntity.ok(itemService.getAllByLocationId(locationId));
    }

    @GetMapping(path = "/getAllEmptyByLocationId")
    public ResponseEntity<List<ItemDto>> getAllEmptyByLocationId(@RequestParam Long locationId) {
        return ResponseEntity.ok(itemService.getAllEmptyByLocationId(locationId));
    }

    @GetMapping(path = "/getAllNonEmptyByLocationId")
    public ResponseEntity<List<ItemDto>> getAllNonEmptyByLocationId(@RequestParam Long locationId) {
        return ResponseEntity.ok(itemService.getAllNonEmptyByLocationId(locationId));
    }


    @GetMapping(path = "/getAllEmpty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemDto>> getAllEmpty() {
        return ResponseEntity.ok(itemService.getAllEmpty());
    }

    @GetMapping(path = "/getAllNonEmpty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemDto>> getAllNonEmpty() {
        return ResponseEntity.ok(itemService.getAllNonEmpty());
    }

    @GetMapping(path = "/getByTypeId", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemDto>> getByTypeId(@RequestParam Long typeId) {
        return ResponseEntity.ok(itemService.getByTypeId(typeId));
    }

    @GetMapping(path = "/getEmptyByTypeId", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemDto>> getEmptyByTypeId(@RequestParam Long typeId) {
        return ResponseEntity.ok(itemService.getEmptyByTypeId(typeId));
    }

    @GetMapping(path = "/getNonEmptyByTypeId", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemDto>> getNonEmptyByTypeId(@RequestParam Long typeId) {
        return ResponseEntity.ok(itemService.getNonEmptyByTypeId(typeId));
    }

    @GetMapping(path = "/getById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemDto> getById(@RequestParam Long itemId) {
        return ResponseEntity.ok(itemService.getById(itemId));
    }

    @PostMapping(path = "/createType", produces = MediaType.APPLICATION_JSON_VALUE)
    public Long createType(@RequestBody ItemTypeDto itemTypeDto) {
        System.out.println(itemTypeDto.getId()+" "+itemTypeDto.getDescription()+" "+itemTypeDto.getGroupId());
        return itemService.createType(itemTypeDto);
    }

    //Must create transaction!!!
    @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto) {
        Optional<ItemDto> createdItemDto = itemService.createItem(itemDto);
        return createdItemDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_MODIFIED).build());
    }

    @PostMapping(path = "/updateType")
    public void updateType(@RequestBody ItemTypeDto itemTypeDto) {
        itemService.updateType(itemTypeDto);
    }

    @PostMapping(path = "/update")
    public void update(@RequestBody ItemDto itemDto) {
        itemService.update(itemDto);
    }

    @DeleteMapping(path = "/deleteType")
    public void deleteType(@RequestBody ItemTypeDto itemTypeDto) {
        itemService.deleteType(itemTypeDto);
    }

    @DeleteMapping(path = "/delete")
    public void delete(@RequestBody ItemDto itemDto) {
        itemService.delete(itemDto);
    }


    @DeleteMapping(path = "/deleteByTypeId")
    public void delete(@RequestParam Long typeId) {
        itemService.deleteByTypeId(typeId);
    }
}
