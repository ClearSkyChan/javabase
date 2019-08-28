package com.clearsky.javabase.domain.model;

import java.util.Date;

public class Flight {
    public Date getAtd() {
        return atd;
    }

    public void setAtd(Date atd) {
        this.atd = atd;
    }


    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    private String flightNo;
    private Date atd;

}
