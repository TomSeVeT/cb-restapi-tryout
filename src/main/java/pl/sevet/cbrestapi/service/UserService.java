package pl.sevet.cbrestapi.service;

import pl.sevet.cbrestapi.dto.UserDto;
import pl.sevet.cbrestapi.dto.UserLoginDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAll();

    Long create(UserLoginDto userLoginDto);

    void update(UserDto userDto);

    boolean updatePass(UserLoginDto userLoginDto);

    void delete(UserDto userDto);
}
