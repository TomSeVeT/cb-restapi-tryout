package pl.sevet.cbrestapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sevet.cbrestapi.dto.LocationDto;
import pl.sevet.cbrestapi.mapper.LocationMapper;
import pl.sevet.cbrestapi.model.Location;
import pl.sevet.cbrestapi.repository.LocationRepository;
import pl.sevet.cbrestapi.repository.UserAccessRepository;
import pl.sevet.cbrestapi.service.LocationService;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final UserAccessRepository userAccessRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository, UserAccessRepository userAccessRepository) {
        this.locationRepository = locationRepository;
        this.userAccessRepository = userAccessRepository;
    }

    @Override
    public Long create(LocationDto locationDto) {
        Location createdLocation = locationRepository.save(LocationMapper.dtoToLocation(locationDto));
        return createdLocation.getId();
    }

    @Override
    public List<LocationDto> getAll() {
        List<LocationDto> locationDtos = new ArrayList<>();
        locationRepository.findAll().forEach(x -> locationDtos.add(LocationMapper.locationToDto(x)));
        return locationDtos;
    }

    @Override
    public List<LocationDto> getByUserId(Long userId) {
        List<LocationDto> locationDtos = new ArrayList<>();
        userAccessRepository.findAllByUserId(userId).forEach(x ->
                locationDtos.add(LocationMapper.locationToDto(
                        locationRepository.findById(x.getLocationId()).get()
                )));
        return locationDtos;

    }

    @Override
    public void update(LocationDto locationDto) {
        locationRepository.save(LocationMapper.dtoToLocation(locationDto));
    }

    @Override
    public void delete(LocationDto locationDto) {
        locationRepository.delete(LocationMapper.dtoToLocation(locationDto));
    }
}
