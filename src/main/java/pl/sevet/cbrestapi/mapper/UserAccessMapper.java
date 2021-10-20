package pl.sevet.cbrestapi.mapper;

import pl.sevet.cbrestapi.dto.UserAccessDto;
import pl.sevet.cbrestapi.model.UserAccess;

public class UserAccessMapper {
    public static UserAccessDto accessToDto(UserAccess userAccess) {
        return new UserAccessDto(userAccess.getUserId(), userAccess.getLocationId());
    }

    public static UserAccess dtoToAccess(UserAccessDto userAccessDto) {
        return new UserAccess(userAccessDto.getUserId(), userAccessDto.getLocationId());
    }

}
