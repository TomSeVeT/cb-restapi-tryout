package pl.sevet.cbrestapi.mapper;

import pl.sevet.cbrestapi.dto.UserDto;
import pl.sevet.cbrestapi.model.User;

public class UserMapper {
    public static UserDto userToDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getSurname(), user.isAdmin());
    }

    public static User dtoToUser(UserDto userDto) {
        return new User(userDto.getId(), userDto.getName(), userDto.getSurname(), userDto.isAdmin());
    }
}
