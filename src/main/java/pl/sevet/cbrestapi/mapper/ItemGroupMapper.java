package pl.sevet.cbrestapi.mapper;

import pl.sevet.cbrestapi.dto.ItemGroupDto;
import pl.sevet.cbrestapi.model.ItemGroup;

public class ItemGroupMapper {
    public static ItemGroupDto itemGroupToDto(ItemGroup itemGroup) {
        return new ItemGroupDto(itemGroup.getId(), itemGroup.getName(), itemGroup.getMeasurement(), itemGroup.isExpDate());
    }

    public static ItemGroup dtoToItemGroup(ItemGroupDto itemGroupDto){
        return new ItemGroup(itemGroupDto.getId(), itemGroupDto.getName(), itemGroupDto.getMeasurement(), itemGroupDto.isExpDate());
    }
}
