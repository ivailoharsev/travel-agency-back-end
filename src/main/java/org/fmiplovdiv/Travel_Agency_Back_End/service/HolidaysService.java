package org.fmiplovdiv.Travel_Agency_Back_End.service;

import org.fmiplovdiv.Travel_Agency_Back_End.dto.CreateHolidayDTO;
import org.fmiplovdiv.Travel_Agency_Back_End.dto.UpdateHolidayDTO;
import org.fmiplovdiv.Travel_Agency_Back_End.dto.ResponseHolidayDTO;
import org.fmiplovdiv.Travel_Agency_Back_End.model.Holiday;

import java.util.List;

public interface HolidaysService {

    void saveNewHoliday(CreateHolidayDTO createHolidayRequestDTO);
    List<ResponseHolidayDTO> getAllHolidays();
    Holiday getHolidayById(int holidayId);
    void deleteHolidayByID(int id);
    ResponseHolidayDTO holidayToHolidayResponseMapper(Holiday holiday);
    Holiday holidayRequestToHolidayMapper(CreateHolidayDTO createHolidayDTO);

}
