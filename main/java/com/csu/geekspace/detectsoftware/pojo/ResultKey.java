package com.csu.geekspace.detectsoftware.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class ResultKey {
    private String data_position_area;

    private Integer data_position_line;

    private Integer data_position_station;

    private BigDecimal data_f;

    private Date data_t;

    public String getData_position_area() {
        return data_position_area;
    }

    public void setData_position_area(String data_position_area) {
        this.data_position_area = data_position_area == null ? null : data_position_area.trim();
    }

    public Integer getData_position_line() {
        return data_position_line;
    }

    public void setData_position_line(Integer data_position_line) {
        this.data_position_line = data_position_line;
    }

    public Integer getData_position_station() {
        return data_position_station;
    }

    public void setData_position_station(Integer data_position_station) {
        this.data_position_station = data_position_station;
    }

    public BigDecimal getData_f() {
        return data_f;
    }

    public void setData_f(BigDecimal data_f) {
        this.data_f = data_f;
    }

    public Date getData_t() {
        return data_t;
    }

    public void setData_t(Date data_t) {
        this.data_t = data_t;
    }
}