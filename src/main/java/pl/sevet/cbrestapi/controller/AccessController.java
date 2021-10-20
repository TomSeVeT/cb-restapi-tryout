package pl.sevet.cbrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.sevet.cbrestapi.dto.UserAccessDto;
import pl.sevet.cbrestapi.service.AccessService;

import java.util.List;

@RestController
@RequestMapping("/access")
public class AccessController {

    private final AccessService accessService;

    @Autowired
    public AccessController(AccessService accessService) {
        this.accessService = accessService;
    }

    @PostMapping(path = "/create")
    public void newAccess(@RequestBody List<UserAccessDto> userAccessDto) {
        accessService.newAccess(userAccessDto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Long> getUserAccess(@RequestParam Long userId) {
        return accessService.access(userId);
    }

    @GetMapping(path = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserAccessDto> allAccess() {
        return accessService.allAccess();
    }

    @PostMapping(path = "/delete")
    public void deleteAccess(@RequestBody List<UserAccessDto> userAccessDto) {
        accessService.deleteAccess(userAccessDto);
    }

}
