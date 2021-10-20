package pl.sevet.cbrestapi.service;

import pl.sevet.cbrestapi.dto.LocationDto;

import java.util.List;

public interface LocationService {
    Long create(LocationDto locationDto);

    List<LocationDto> getAll();

    List<LocationDto> getByUserId(Long userId);

    void update(LocationDto locationDto);

    void delete(LocationDto locationDto);
}
