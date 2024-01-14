package org.fmiplovdiv.Travel_Agency_Back_End.repositories;

import org.fmiplovdiv.Travel_Agency_Back_End.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationsRepository extends JpaRepository<Location, Integer> {

}
