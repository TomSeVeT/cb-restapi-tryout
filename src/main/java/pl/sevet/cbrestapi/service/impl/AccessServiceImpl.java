package pl.sevet.cbrestapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sevet.cbrestapi.dto.UserAccessDto;
import pl.sevet.cbrestapi.mapper.UserAccessMapper;
import pl.sevet.cbrestapi.repository.UserAccessRepository;
import pl.sevet.cbrestapi.service.AccessService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccessServiceImpl implements AccessService {
    private final UserAccessRepository accessRepository;

    @Autowired
    public AccessServiceImpl(UserAccessRepository accessRepository) {
        this.accessRepository = accessRepository;
    }

    @Override
    public void newAccess(List<UserAccessDto> userAccessDtos) {
        userAccessDtos.forEach(userAccessDto ->
                accessRepository.save(UserAccessMapper.dtoToAccess(userAccessDto)));
    }

    @Override
    public List<Long> access(Long userId) {
        List<Long> accessList = new ArrayList<>();
        accessRepository.findAllByUserId(userId).forEach(x ->
                accessList.add(x.getLocationId()));
        return accessList;
    }

    @Override
    public List<UserAccessDto> allAccess() {
        List<UserAccessDto> userAccessDtos = new ArrayList<>();
        accessRepository.findAll().forEach(x ->
                userAccessDtos.add(UserAccessMapper.accessToDto(x)));
        return userAccessDtos;
    }

    @Override
    public void deleteAccess(List<UserAccessDto> userAccessDtos) {
        userAccessDtos.forEach(userAccessDto ->
            accessRepository.deleteAllByUserIdAndLocationId(userAccessDto.getUserId(), userAccessDto.getLocationId()));
    }
}
