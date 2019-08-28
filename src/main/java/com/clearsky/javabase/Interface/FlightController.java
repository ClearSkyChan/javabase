package com.clearsky.javabase.Interface;

import com.clearsky.javabase.application.FlightDynamicService;
import com.clearsky.javabase.application.dto.FlightDto;
import com.clearsky.javabase.domain.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class FlightController {
    @Autowired
    FlightDynamicService _flightDynamicService;

    @GetMapping("/flights")
    public List<FlightDto> Get(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        List<FlightDto> flights = _flightDynamicService.GetFlights(date);
        return flights;
    }
}
