package pl.sevet.cbrestapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sevet.cbrestapi.dto.UserDto;
import pl.sevet.cbrestapi.dto.UserLoginDto;
import pl.sevet.cbrestapi.mapper.UserMapper;
import pl.sevet.cbrestapi.model.User;
import pl.sevet.cbrestapi.model.UserSecPass;
import pl.sevet.cbrestapi.repository.UserRepository;
import pl.sevet.cbrestapi.repository.UserSecPassRepository;
import pl.sevet.cbrestapi.service.LoginService;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;
    private final UserSecPassRepository userSecPassRepository;

    @Autowired
    public LoginServiceImpl(UserRepository userRepository, UserSecPassRepository userSecPassRepository) {
        this.userRepository = userRepository;
        this.userSecPassRepository = userSecPassRepository;
    }

    @Override
    public Optional<UserDto> tryLogin(UserLoginDto userLoginDto) {
        User user = userRepository.findByLogin(userLoginDto.getLogin());
        if (user == null)
            return Optional.empty();

        Optional<UserSecPass> userSecPass = userSecPassRepository.findByUserId(user.getId());
        if (userSecPass.isEmpty())
            return Optional.empty();

        else if (userSecPass.get().getUserPass().equals(userLoginDto.getPassword()))
            return Optional.of(UserMapper.userToDto(user));

        else
            return Optional.empty();
    }
}
