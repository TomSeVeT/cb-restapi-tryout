package pl.sevet.cbrestapi.service;

import pl.sevet.cbrestapi.dto.UserDto;
import pl.sevet.cbrestapi.dto.UserLoginDto;

import java.util.Optional;

public interface LoginService {
    Optional<UserDto> tryLogin(UserLoginDto userLoginDto);
}
