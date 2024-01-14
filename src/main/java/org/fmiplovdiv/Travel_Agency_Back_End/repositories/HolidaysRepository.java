package org.fmiplovdiv.Travel_Agency_Back_End.repositories;

import org.fmiplovdiv.Travel_Agency_Back_End.model.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends JpaRepository<Holiday, Integer> {
}
