package org.fmiplovdiv.Travel_Agency_Back_End.repositories;

import org.fmiplovdiv.Travel_Agency_Back_End.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservation, Integer> {
    Reservation findReservationByPhoneNumber(String phoneNumber);
}
