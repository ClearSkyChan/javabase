package com.clearsky.javabase.domain.repository;

import com.clearsky.javabase.domain.model.Flight;
import org.springframework.data.repository.Repository;

public interface FlightRepository extends Repository<Flight, String> {
    Flight findById(String id);
    Flight save(Flight flight);
}
