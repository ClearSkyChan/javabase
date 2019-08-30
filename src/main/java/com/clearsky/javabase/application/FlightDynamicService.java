package com.clearsky.javabase.application;
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
        String sql = "select flight_no,flight_id,atd,flight_date from flight where flight_date=:dt";
        List<FlightDto> flights =  _dbQuery.SelectList(FlightDto.class,sql, DateUtil.ToDate(date));
        return flights;
    }

    public void UpdateAtd(String flightId, OffsetDateTime date){
        Flight flight = _flightRepository.findById(flightId);
        flight.setAtd(date);
        _flightRepository.save(flight);
    }
}
