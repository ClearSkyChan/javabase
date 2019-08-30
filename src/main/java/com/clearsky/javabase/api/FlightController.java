package com.clearsky.javabase.api;

import com.clearsky.javabase.application.FlightDynamicService;
import com.clearsky.javabase.application.dto.FlightDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
public class FlightController {
    @Autowired
    FlightDynamicService _flightDynamicService;

    @GetMapping("/flights")
    public List<FlightDto> Get(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        List<FlightDto> flights = _flightDynamicService.GetFlights(date);
        return flights;
    }

    @PostMapping("/flight/{id}/atd")
    public void UpdateAtd(@PathVariable String id,@RequestBody @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") OffsetDateTime date){
        _flightDynamicService.UpdateAtd(id,date);
    }
}
