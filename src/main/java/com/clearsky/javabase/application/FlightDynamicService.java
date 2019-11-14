package com.clearsky.javabase.application;
import com.clearsky.javabase.domain.model.Airport;
import com.clearsky.javabase.infrastructure.DateUtil;
import com.clearsky.javabase.infrastructure.DbQuery;
import com.clearsky.javabase.application.dto.FlightDto;
import com.clearsky.javabase.domain.model.Flight;
import com.clearsky.javabase.domain.repository.FlightRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.LinkedList;
import java.util.List;

@Service
public class FlightDynamicService {

    @Autowired
    private ModelMapper _mapper;

    @Autowired
    private DbQuery _dbQuery;

    @Autowired
    private FlightRepository _flightRepository;

    public List<FlightDto> GetFlights(LocalDate date){
        String sql = "select flight_no,flight_id,std,sta,flight_date from flight where flight_date=:dt";
        List<FlightDto> flights =  _dbQuery.SelectList(FlightDto.class,sql, DateUtil.ToDate(date));
        return flights;
    }

    public void UpdateAtd(String flightId, OffsetDateTime date){
        Flight flight = _flightRepository.findById(flightId);
        Airport airport = flight.getDepartureAirport();
        String code = airport.getAp4Code();
        String name = airport.getChineseName();
        flight.setAtd(date);
        _flightRepository.save(flight);
    }
}
