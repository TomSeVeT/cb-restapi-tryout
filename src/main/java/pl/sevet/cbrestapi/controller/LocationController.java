package pl.sevet.cbrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sevet.cbrestapi.dto.LocationDto;
import pl.sevet.cbrestapi.service.LocationService;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Long create(@RequestBody LocationDto locationDto) {
        return locationService.create(locationDto);
    }

    @GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LocationDto>> getAll() {
        return ResponseEntity.ok(locationService.getAll());
    }

    @GetMapping(path = "/getByUserId", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LocationDto>> getByUserId(@RequestParam Long userId) {
        return ResponseEntity.ok(locationService.getByUserId(userId));
    }

    @PostMapping(path = "/update")
    public void update(@RequestBody LocationDto locationDto) {
        locationService.update(locationDto);
    }

    @DeleteMapping(path = "/delete")
    public void delete(@RequestBody LocationDto locationDto) {
        locationService.delete(locationDto);
    }

}
