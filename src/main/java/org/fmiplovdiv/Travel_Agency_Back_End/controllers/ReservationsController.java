package org.fmiplovdiv.Travel_Agency_Back_End.controllers;

import org.fmiplovdiv.Travel_Agency_Back_End.dto.CreateReservationDTO;
import org.fmiplovdiv.Travel_Agency_Back_End.dto.UpdateReservationDTO;
import org.fmiplovdiv.Travel_Agency_Back_End.dto.ResponseReservationDTO;
import org.fmiplovdiv.Travel_Agency_Back_End.model.Reservation;
import org.fmiplovdiv.Travel_Agency_Back_End.service.ReservationsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationsController {

    private ReservationsService reservationService;

    public ReservationsController(ReservationsService reservationService) {
        this.reservationService = reservationService;
    }

}
