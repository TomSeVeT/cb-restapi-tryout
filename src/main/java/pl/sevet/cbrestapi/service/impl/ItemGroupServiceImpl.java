package pl.sevet.cbrestapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sevet.cbrestapi.dto.ItemGroupDto;
import pl.sevet.cbrestapi.mapper.ItemGroupMapper;
import pl.sevet.cbrestapi.repository.ItemGroupRepository;
import pl.sevet.cbrestapi.service.ItemGroupService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemGroupServiceImpl implements ItemGroupService {

    private final ItemGroupRepository groupRepository;

    @Autowired
    public ItemGroupServiceImpl(ItemGroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<ItemGroupDto> getAll() {
        List<ItemGroupDto> itemGroupDtos = new ArrayList<>();
        groupRepository.findAll().forEach(x -> itemGroupDtos.add(ItemGroupMapper.itemGroupToDto(x)));
        return itemGroupDtos;
    }

    @Override
    public Long create(ItemGroupDto itemGroupDto) {
        return groupRepository.save(ItemGroupMapper.dtoToItemGroup(itemGroupDto)).getId();
    }
}
