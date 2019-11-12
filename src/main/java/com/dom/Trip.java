package com.dom;

import javax.persistence.*;

@Entity
public class Trip {

    @Id
    @GeneratedValue
    private int id;

    private int carriageQuantity;

    private boolean rapidTransit;

    private String travelTime;

    @Embedded
    private DateAndTime dateAndTime;

    @Enumerated(EnumType.STRING)
    private CityRun departureCity;

    @Enumerated(EnumType.STRING)
    private CityRun arrivalCity;

    public Trip() {
    }

    public Trip(int carriageQuantity, boolean rapidTransit, String travelTime, CityRun departureCity, CityRun arrivalCity) {
        this.carriageQuantity = carriageQuantity;
        this.rapidTransit = rapidTransit;
        this.travelTime = travelTime;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarriageQuantity() {
        return carriageQuantity;
    }

    public void setCarriageQuantity(int carriageQuantity) {
        this.carriageQuantity = carriageQuantity;
    }

    public boolean isRapidTransit() {
        return rapidTransit;
    }

    public void setRapidTransit(boolean rapidTransit) {
        this.rapidTransit = rapidTransit;
    }

    public DateAndTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(DateAndTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public CityRun getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(CityRun cityRun) {
        this.departureCity = cityRun;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    public CityRun getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(CityRun arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", carriageQuantity=" + carriageQuantity +
                ", rapidTransit=" + rapidTransit +
                ", travelTime='" + travelTime + '\'' +
                ", dateAndTime=" + dateAndTime +
                ", departureCity=" + departureCity +
                ", arrivalCity=" + arrivalCity +
                '}';
    }
}
