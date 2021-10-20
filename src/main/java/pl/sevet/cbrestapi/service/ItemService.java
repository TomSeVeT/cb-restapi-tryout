package pl.sevet.cbrestapi.service;

import pl.sevet.cbrestapi.dto.ItemDto;
import pl.sevet.cbrestapi.dto.ItemTypeDto;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    List<ItemTypeDto> getAllTypes();

    List<ItemDto> getAllItems();

    List<ItemDto> getAllEmpty();

    List<ItemDto> getAllNonEmpty();

    List<ItemDto> getAllByLocationId(Long locationId);

    List<ItemDto> getAllEmptyByLocationId(Long locationId);

    List<ItemDto> getAllNonEmptyByLocationId(Long locationId);

    List<ItemDto> getByTypeId(Long typeId);

    List<ItemDto> getEmptyByTypeId(Long typeId);

    List<ItemDto> getNonEmptyByTypeId(Long typeId);

    ItemDto getById(Long itemId);

    Long createType(ItemTypeDto itemTypeDto);

    Optional<ItemDto> createItem(ItemDto itemDto);

    void updateType(ItemTypeDto itemTypeDto);

    void update(ItemDto itemDto);

    void deleteType(ItemTypeDto itemTypeDto);

    void delete(ItemDto itemDto);

    void deleteByTypeId(Long typeId);

}
