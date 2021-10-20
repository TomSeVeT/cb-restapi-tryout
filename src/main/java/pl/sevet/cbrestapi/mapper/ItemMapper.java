package pl.sevet.cbrestapi.mapper;

import pl.sevet.cbrestapi.dto.ItemDto;
import pl.sevet.cbrestapi.model.Item;

public class ItemMapper {
    public static ItemDto itemToDto(Item item) {
        return new ItemDto(item.getId(), item.getDescription(), item.getQuantity(),
                item.getTypeId(), item.getLocationId(), item.getExpDate(), item.getCreationDate());
    }

    public static Item dtoToItem(ItemDto itemDto) {
        return new Item(itemDto.getId(), itemDto.getDescription(), itemDto.getQuantity(),
                itemDto.getTypeId(), itemDto.getLocationId(), itemDto.getExpDate(), itemDto.getCreationDate());
    }
}
