package pl.sevet.cbrestapi.service;

import org.springframework.transaction.annotation.Transactional;
import pl.sevet.cbrestapi.dto.UserAccessDto;

import java.util.List;

public interface AccessService {

    List<Long> access(Long userId);

    List<UserAccessDto> allAccess();

    void newAccess(List<UserAccessDto> userAccessDto);

    @Transactional
    void deleteAccess(List<UserAccessDto> userAccessDto);
}
