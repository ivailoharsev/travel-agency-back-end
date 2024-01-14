package org.fmiplovdiv.Travel_Agency_Back_End.controllers;

import org.fmiplovdiv.Travel_Agency_Back_End.dto.CreateHolidayDTO;
import org.fmiplovdiv.Travel_Agency_Back_End.dto.ResponseHolidayDTO;
import org.fmiplovdiv.Travel_Agency_Back_End.model.Holiday;
import org.fmiplovdiv.Travel_Agency_Back_End.service.HolidaysService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/holidays")
public class HolidaysController {

    private HolidaysService holidaysService;

    public HolidaysController(HolidaysService holidaysService) {
        this.holidaysService = holidaysService;
    }

    @PostMapping()
    public ResponseEntity<Object> saveNewHoliday(
            @RequestBody CreateHolidayDTO createHolidayDTO) {
        holidaysService.saveNewHoliday(createHolidayDTO);
        return new ResponseEntity<>("Saved", HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ResponseHolidayDTO>> getAllHolidays() {
        return new ResponseEntity<>(holidaysService.getAllHolidays(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Holiday> getLocationById(@PathVariable int id) {
        return new ResponseEntity<>(holidaysService.getHolidayById(id), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable int id) {
        holidaysService.deleteHolidayByID(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);

    }

}
