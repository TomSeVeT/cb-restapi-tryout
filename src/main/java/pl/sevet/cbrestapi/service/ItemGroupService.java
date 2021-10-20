package pl.sevet.cbrestapi.service;

import pl.sevet.cbrestapi.dto.ItemGroupDto;

import java.util.List;

public interface ItemGroupService {
    List<ItemGroupDto> getAll();

    Long create(ItemGroupDto itemGroupDto);
}
