package com.csu.geekspace.detectsoftware.pojo;

import java.math.BigDecimal;

public class Data extends DataKey {
    private BigDecimal i;

    private BigDecimal u;

    private BigDecimal err;

    /*public Data(){}
    public Data(BigDecimal i,BigDecimal u){}*/

    public BigDecimal getI() {
        return i;
    }

    public void setI(BigDecimal i) {
        this.i = i;
    }

    public BigDecimal getU() {
        return u;
    }

    public void setU(BigDecimal u) {
        this.u = u;
    }

    public BigDecimal getErr() {
        return err;
    }

    public void setErr(BigDecimal err) {
        this.err = err;
    }

    @Override
    public String toString() {
        return "Data{" +
                "i=" + i +
                ", u=" + u +
                ", err=" + err +
                "position_area='" + super.getPosition_area() + '\'' +
                ", position_line=" + super.getPosition_line() +
                ", position_station=" + super.getPosition_station() +
                ", f=" + super.getF() +
                ", t=" + super.getT() +
                '}';
    }
}