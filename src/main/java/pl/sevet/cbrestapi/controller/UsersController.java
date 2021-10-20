package pl.sevet.cbrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sevet.cbrestapi.dto.UserDto;
import pl.sevet.cbrestapi.dto.UserLoginDto;
import pl.sevet.cbrestapi.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    //Create usersecpass and user with only id and login and return id must updateDesc!
    @PostMapping(value = "/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public Long create(@RequestBody UserLoginDto userLoginDtoDto) {
        return userService.create(userLoginDtoDto);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/getAll")
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping("/updateDesc")
    public void update(@RequestBody UserDto userDto) {
        userService.update(userDto);
    }

    @PostMapping("/updatePass")
    public ResponseEntity updatePass(@RequestBody UserLoginDto userLoginDto) {
        boolean passChanged = userService.updatePass(userLoginDto);
        if (passChanged)
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @PostMapping("/delete")
    public void delete(@RequestBody UserDto userDto) {
        userService.delete(userDto);
    }
}
