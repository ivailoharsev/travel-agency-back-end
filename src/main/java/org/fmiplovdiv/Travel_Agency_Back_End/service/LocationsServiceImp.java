package org.fmiplovdiv.Travel_Agency_Back_End.service;

import org.fmiplovdiv.Travel_Agency_Back_End.repositories.LocationsRepository;
import org.fmiplovdiv.Travel_Agency_Back_End.dto.CreateLocationDTO;
import org.fmiplovdiv.Travel_Agency_Back_End.dto.ResponseLocationDTO;
import org.fmiplovdiv.Travel_Agency_Back_End.model.Location;
import org.fmiplovdiv.Travel_Agency_Back_End.service.LocationsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationsServiceImp implements LocationsService {

    LocationsRepository locationsRepository;

    public LocationsServiceImp(LocationsRepository locationsRepository) {
        this.locationsRepository = locationsRepository;
    }

    @Override
    public void saveNewLocation(CreateLocationDTO createLocationDTO) {
        Location locationToSave = locationRequestToLocationMapper(createLocationDTO);
        locationsRepository.save(locationToSave);

    }

    @Override
    public List<ResponseLocationDTO> getAllLocations() {
        return locationsRepository.findAll().stream().map(this::locationToLocationResponseMapper).toList();
    }

    @Override
    public Location getLocationEntityById(int id) {
        return locationsRepository.findById(id).get();
    }


    @Override
    public void deleteLocationById(int id) {
        locationsRepository.deleteById(id);
    }

    @Override
    public ResponseLocationDTO locationToLocationResponseMapper(Location location) {
        return new ResponseLocationDTO(location.getId(), location.getStreet(), location.getNumber(), location.getCity(), location.getCountry(), location.getImageUrl());
    }

    @Override
    public Location locationRequestToLocationMapper(CreateLocationDTO createLocationDTO) {
        return new Location(createLocationDTO.getStreet(), createLocationDTO.getNumber(), createLocationDTO.getCity(), createLocationDTO.getCountry(), createLocationDTO.getImageUrl());
    }



}
