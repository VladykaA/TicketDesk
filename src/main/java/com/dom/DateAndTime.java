package com.dom;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Embeddable
public class DateAndTime {

    @Column(name = "departure_date")
    @Temporal(TemporalType.DATE)
    private Date departureDate;

    @Column(name = "departure_time")
    @Temporal(TemporalType.TIME)
    private Date departureTime;

    public DateAndTime() {
    }

    public DateAndTime(Date departureDate, Date departureTime) {
        this.departureDate = departureDate;
        this.departureTime = departureTime;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date journeyTime) {
        this.departureTime = journeyTime;
    }

}
