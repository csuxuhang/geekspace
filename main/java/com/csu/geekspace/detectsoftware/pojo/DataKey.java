package com.csu.geekspace.detectsoftware.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class DataKey {
    private String position_area;

    private Integer position_line;

    private Integer position_station;

    private BigDecimal f;

    private Date t;

    public String getPosition_area() {
        return position_area;
    }

    public void setPosition_area(String position_area) {
        this.position_area = position_area == null ? null : position_area.trim();
    }

    public Integer getPosition_line() {
        return position_line;
    }

    public void setPosition_line(Integer position_line) {
        this.position_line = position_line;
    }

    public Integer getPosition_station() {
        return position_station;
    }

    public void setPosition_station(Integer position_station) {
        this.position_station = position_station;
    }

    public BigDecimal getF() {
        return f;
    }

    public void setF(BigDecimal f) {
        this.f = f;
    }

    public Date getT() {
        return t;
    }

    public void setT(Date t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "DataKey{" +
                "position_area='" + position_area + '\'' +
                ", position_line=" + position_line +
                ", position_station=" + position_station +
                ", f=" + f +
                ", t=" + t +
                '}';
    }
}