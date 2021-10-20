package pl.sevet.cbrestapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sevet.cbrestapi.dto.ItemDto;
import pl.sevet.cbrestapi.dto.ItemTypeDto;
import pl.sevet.cbrestapi.mapper.ItemMapper;
import pl.sevet.cbrestapi.mapper.ItemTypeMapper;
import pl.sevet.cbrestapi.model.Item;
import pl.sevet.cbrestapi.model.ItemType;
import pl.sevet.cbrestapi.repository.ItemRepository;
import pl.sevet.cbrestapi.repository.ItemTypeRepository;
import pl.sevet.cbrestapi.repository.TransactionRepository;
import pl.sevet.cbrestapi.service.ItemService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ItemTypeRepository typeRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, ItemTypeRepository typeRepository, TransactionRepository transactionRepository) {
        this.itemRepository = itemRepository;
        this.typeRepository = typeRepository;
    }


    @Override
    public List<ItemTypeDto> getAllTypes() {
        List<ItemTypeDto> itemTypeDtos = new ArrayList<>();
        typeRepository.findAll().forEach(x -> itemTypeDtos.add(ItemTypeMapper.itemTypeToDto(x)));
        return itemTypeDtos;
    }

    @Override
    public List<ItemDto> getAllItems() {
        List<ItemDto> itemDtos = new ArrayList<>();
        itemRepository.findAll().forEach(x -> itemDtos.add(ItemMapper.itemToDto(x)));
        return itemDtos;
    }

    @Override
    public List<ItemDto> getAllEmpty() {
        List<ItemDto> itemDtos = new ArrayList<>();
        itemRepository.findAllByQuantityIs(0).forEach(x -> itemDtos.add(ItemMapper.itemToDto(x)));
        return itemDtos;
    }

    @Override
    public List<ItemDto> getAllNonEmpty() {
        List<ItemDto> itemDtos = new ArrayList<>();
        itemRepository.findAllByQuantityGreaterThan(0).forEach(x -> itemDtos.add(ItemMapper.itemToDto(x)));
        return itemDtos;
    }

    @Override
    public List<ItemDto> getAllByLocationId(Long locationId) {
        List<ItemDto> itemDtos = new ArrayList<>();
        itemRepository.findAllByLocationId(locationId).forEach(x -> itemDtos.add(ItemMapper.itemToDto(x)));
        return itemDtos;
    }

    @Override
    public List<ItemDto> getAllEmptyByLocationId(Long locationId) {
        List<ItemDto> itemDtos = new ArrayList<>();
        itemRepository.findAllByLocationIdAndQuantityIs(locationId, 0).forEach(x -> itemDtos.add(ItemMapper.itemToDto(x)));
        return itemDtos;
    }

    @Override
    public List<ItemDto> getAllNonEmptyByLocationId(Long locationId) {
        List<ItemDto> itemDtos = new ArrayList<>();
        itemRepository.findAllByLocationIdAndQuantityGreaterThan(locationId, 0).forEach(x -> itemDtos.add(ItemMapper.itemToDto(x)));
        return itemDtos;
    }

    @Override
    public List<ItemDto> getByTypeId(Long typeId) {
        List<ItemDto> itemDtos = new ArrayList<>();
        itemRepository.findAllByTypeId(typeId).forEach(x -> itemDtos.add(ItemMapper.itemToDto(x)));
        return itemDtos;
    }

    @Override
    public List<ItemDto> getEmptyByTypeId(Long typeId) {
        List<ItemDto> itemDtos = new ArrayList<>();
        itemRepository.findAllByTypeIdAndQuantityIs(typeId, 0).forEach(x -> itemDtos.add(ItemMapper.itemToDto(x)));
        return itemDtos;
    }

    @Override
    public List<ItemDto> getNonEmptyByTypeId(Long typeId) {
        List<ItemDto> itemDtos = new ArrayList<>();
        itemRepository.findAllByTypeIdAndQuantityGreaterThan(typeId, 0).forEach(x -> itemDtos.add(ItemMapper.itemToDto(x)));
        return itemDtos;
    }

    @Override
    public ItemDto getById(Long itemId) {
        return ItemMapper.itemToDto(itemRepository.findById(itemId).get());
    }

    @Override
    public Long createType(ItemTypeDto itemTypeDto) {
        ItemType createdType = typeRepository.save(ItemTypeMapper.dtoToItemType(itemTypeDto));
        return createdType.getId();
    }

    @Override
    public Optional<ItemDto> createItem(ItemDto itemDto) {
        Item createdItem = itemRepository.save(ItemMapper.dtoToItem(itemDto));
        if (createdItem.getId() != null)
            return Optional.of(ItemMapper.itemToDto(createdItem));
        else
            return Optional.empty();
    }

    @Override
    public void updateType(ItemTypeDto itemTypeDto) {
        typeRepository.save(ItemTypeMapper.dtoToItemType(itemTypeDto));
    }

    @Override
    public void update(ItemDto itemDto) {
        itemRepository.save(ItemMapper.dtoToItem(itemDto));

    }

    @Override
    public void deleteType(ItemTypeDto itemTypeDto) {
        typeRepository.delete(ItemTypeMapper.dtoToItemType(itemTypeDto));
    }

    @Override
    public void delete(ItemDto itemDto) {
        itemRepository.delete(ItemMapper.dtoToItem(itemDto));
    }

    @Override
    public void deleteByTypeId(Long typeId) {
        itemRepository.deleteAllByTypeId(typeId);
    }
}
