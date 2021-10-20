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
import pl.sevet.cbrestapi.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserSecPassRepository secPassRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserSecPassRepository secPassRepository) {
        this.secPassRepository = secPassRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getAll() {
        List<User> userList = (List<User>) userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        userList.forEach(x -> userDtoList.add(UserMapper.userToDto(x)));
        return userDtoList;
    }

    @Override
    public Long create(UserLoginDto userLoginDtoDto) {
        User user = new User();
        user.setLogin(userLoginDtoDto.getLogin());
        user = userRepository.save(user);
        UserSecPass userSecPass = new UserSecPass(user.getId(), userLoginDtoDto.getPassword());
        secPassRepository.save(userSecPass);
        return user.getId();
    }

    @Override
    public void update(UserDto userDto) {
        User user = UserMapper.dtoToUser(userDto);
        user.setLogin(userRepository.findById(userDto.getId()).get().getLogin());
        userRepository.save(user);
    }


    @Override
    public boolean updatePass(UserLoginDto userLoginDto) {
        Long userId = userRepository.findByLogin(userLoginDto.getLogin()).getId();
        Optional<UserSecPass> userSecPass = secPassRepository.findByUserId(userId);
        if (userSecPass.isPresent()) {
            userSecPass.get().setUserPass(userLoginDto.getPassword());
            return true;
        } else
            return false;
    }

    @Override
    public void delete(UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).get();
        userRepository.delete(user);
        secPassRepository.deleteById(user.getId());
    }
}

