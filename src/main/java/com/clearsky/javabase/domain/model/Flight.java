package com.clearsky.javabase.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Locale;

@Entity
public class Flight {
    public OffsetDateTime getAtd() {
        return atd;
    }

    public void setAtd(OffsetDateTime atd) {
        this.atd = atd;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    @Id
    private String flightId;
    private String flightNo;
    private OffsetDateTime atd;
    private LocalDate flightDate;

}
