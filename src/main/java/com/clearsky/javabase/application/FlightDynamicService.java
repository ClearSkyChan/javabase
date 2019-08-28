package com.clearsky.javabase.application;
import com.clearsky.javabase.Infrastructure.DbQuery;
import com.clearsky.javabase.application.dto.FlightDto;
import com.clearsky.javabase.domain.model.Flight;
import com.clearsky.javabase.domain.repository.Repository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FlightDynamicService {

    @Autowired
    private ModelMapper _mapper;

    @Autowired
    private DbQuery _dbQuery;

    @Autowired
    private Repository<Flight> _flightRepository;

    public List<FlightDto> GetFlights(Date date){
        String sql = "select * from flight";
        List<FlightDto> flights = _dbQuery.Select("sql",date);
        return flights;
    }

    public void UpdateAtd(String flightId,Date date){
        Flight flight = _flightRepository.Get(flightId);
        flight.setAtd(date);
        _flightRepository.Save(flight);
    }
}
