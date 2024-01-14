package org.fmiplovdiv.Travel_Agency_Back_End.service;

import org.fmiplovdiv.Travel_Agency_Back_End.repositories.HolidaysRepository;
import org.fmiplovdiv.Travel_Agency_Back_End.dto.CreateHolidayDTO;
import org.fmiplovdiv.Travel_Agency_Back_End.dto.ResponseHolidayDTO;
import org.fmiplovdiv.Travel_Agency_Back_End.model.Holiday;
import org.fmiplovdiv.Travel_Agency_Back_End.service.HolidaysService;
import org.fmiplovdiv.Travel_Agency_Back_End.service.LocationsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidaysServiceImp implements HolidaysService {
    private final HolidaysRepository holidaysRepository;

    private final LocationsService locationService;

    public HolidaysServiceImp(HolidaysRepository holidaysRepository, LocationsService locationService) {
        this.holidaysRepository = holidaysRepository;
        this.locationService = locationService;
    }


    @Override
    public void saveNewHoliday(CreateHolidayDTO createHolidayRequestDTO) {
        Holiday holidayToSave = holidayRequestToHolidayMapper(createHolidayRequestDTO);
        holidaysRepository.save(holidayToSave);
    }
    @Override
    public List<ResponseHolidayDTO> getAllHolidays() {
        return holidaysRepository.findAll().stream().map(this::holidayToHolidayResponseMapper).toList();
    }

    @Override
    public Holiday getHolidayById(int holidayId) {
        return holidaysRepository.findById(holidayId).get();
    }

    @Override
    public void deleteHolidayByID(int id) {
        holidaysRepository.deleteById(id);
    }

    @Override
    public ResponseHolidayDTO holidayToHolidayResponseMapper(Holiday holiday) {
        return new ResponseHolidayDTO(holiday.getId(), locationService.locationToLocationResponseMapper(locationService.getLocationEntityById((int) holiday.getLocation())), holiday.getTitle(), holiday.getStartDate(), holiday.getDuration(), holiday.getPrice(), holiday.getFreeSlots());
    }

    @Override
    public Holiday holidayRequestToHolidayMapper(CreateHolidayDTO createHolidayDTO) {
        return new Holiday(createHolidayDTO.getLocation(), createHolidayDTO.getTitle(), createHolidayDTO.getStartDate(), createHolidayDTO.getDuration(), createHolidayDTO.getPrice(), createHolidayDTO.getFreeSlots());
    }


}