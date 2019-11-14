package com.clearsky.javabase.application.dto;

import com.clearsky.javabase.infrastructure.Zone;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public class FlightDto {
    private String flightNo;
    @Zone()
    private OffsetDateTime sta;
    @Zone(id="Z")
    private OffsetDateTime std;
    private LocalDate flightDate;

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public OffsetDateTime getSta() {
        return sta;
    }

    public void setSta(OffsetDateTime sta) {
        this.sta = sta;
    }

    public OffsetDateTime getStd() {
        return std;
    }

    public void setStd(OffsetDateTime std) {
        this.std = std;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

}
