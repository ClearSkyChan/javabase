package com.clearsky.javabase.application.dto;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public class FlightDto {
    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    private String flightNo;

    public OffsetDateTime getAtd() {
        return atd;
    }

    public void setAtd(OffsetDateTime atd) {
        this.atd = atd;
    }

    private OffsetDateTime atd;

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    private LocalDate flightDate;
}
