package org.fmiplovdiv.Travel_Agency_Back_End.controllers;

import org.fmiplovdiv.Travel_Agency_Back_End.dto.CreateLocationDTO;
import org.fmiplovdiv.Travel_Agency_Back_End.dto.ResponseLocationDTO;
import org.fmiplovdiv.Travel_Agency_Back_End.model.Location;
import org.fmiplovdiv.Travel_Agency_Back_End.service.LocationsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationsController {

    private LocationsService locationsService;

    public LocationsController(LocationsService locationsService) {
        this.locationsService = locationsService;
    }

    @PostMapping()
    public ResponseEntity<Object> saveNewLocation(
            @RequestBody CreateLocationDTO createLocationDTO) {
        locationsService.saveNewLocation(createLocationDTO);
        return new ResponseEntity<>("Saved", HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<ResponseLocationDTO>> allLocations() {
        return new ResponseEntity<>(locationsService.getAllLocations(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(
            @PathVariable int id) {
        return new ResponseEntity<>(locationsService.getLocationEntityById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteLocationById(@PathVariable int id) {
        locationsService.deleteLocationById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}
