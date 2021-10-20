package pl.sevet.cbrestapi.mapper;

import pl.sevet.cbrestapi.dto.ItemTypeDto;
import pl.sevet.cbrestapi.model.ItemType;

public class ItemTypeMapper {
    public static ItemTypeDto itemTypeToDto(ItemType itemType) {
        return new ItemTypeDto(itemType.getId(), itemType.getGroupId(), itemType.getName(), itemType.getDescription());
    }

    public static ItemType dtoToItemType(ItemTypeDto itemTypeDto) {
        return new ItemType(itemTypeDto.getId(), itemTypeDto.getGroupId(), itemTypeDto.getName(), itemTypeDto.getDescription());
    }
}
