package org.fmiplovdiv.Travel_Agency_Back_End.service;

import org.fmiplovdiv.Travel_Agency_Back_End.dto.CreateLocationDTO;
import org.fmiplovdiv.Travel_Agency_Back_End.dto.ResponseLocationDTO;
import org.fmiplovdiv.Travel_Agency_Back_End.model.Location;

import java.util.List;

public interface LocationsService {
    void saveNewLocation(CreateLocationDTO createLocationDTO);
    List<ResponseLocationDTO> getAllLocations();
    Location getLocationEntityById(int id);
    void deleteLocationById(int id);
    ResponseLocationDTO locationToLocationResponseMapper(Location location);
    Location locationRequestToLocationMapper(CreateLocationDTO createLocationDTO);
}
