package pl.sevet.cbrestapi.mapper;

import pl.sevet.cbrestapi.dto.LocationDto;
import pl.sevet.cbrestapi.model.Location;

public class LocationMapper {

    public static LocationDto locationToDto(Location location) {
        return new LocationDto(location.getId(), location.getName(), location.getDescription());
    }

    public static Location dtoToLocation(LocationDto locationDto) {
        return new Location(locationDto.getId(), locationDto.getName(), locationDto.getDescription());
    }

}
