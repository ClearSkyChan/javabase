package com.clearsky.javabase.domain.model;

import com.clearsky.javabase.infrastructure.Zone;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity
public class Flight {
    @Id
    private String flightId;
    private String flightNo;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="DEPARTURE_AIRPORT")
    private Airport departureAirport;
    private OffsetDateTime std;
    private OffsetDateTime sta;
    private OffsetDateTime atd;
    private LocalDate flightDate;

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public OffsetDateTime getStd() {
        return std;
    }

    public void setStd(OffsetDateTime std) {
        this.std = std;
    }

    public OffsetDateTime getSta() {
        return sta;
    }

    public void setSta(OffsetDateTime sta) {
        this.sta = sta;
    }

    public OffsetDateTime getAtd() {
        return atd;
    }
    public Airport getDepartureAirport() {
        return departureAirport;
    }
    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }
    public void setAtd(OffsetDateTime atd) {
        this.atd = atd;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }
}
