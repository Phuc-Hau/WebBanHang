package com.webbanhang.jpa.model;

import javax.persistence.*;


@NamedStoredProcedureQuery(
        name = "get.TotalMoneyInTheLast3Years",
        procedureName = "TotalMoneyInTheLast3Years",
        resultClasses = TotalMoneyInTheLast3Years.class
)
@Entity
public class TotalMoneyInTheLast3Years {
    
    @Id
    @Column(name = "Thisyear")
    private int thisyear;

    @Column(name = "Lastyear")
    private int lastyear;

    @Column(name = "Twoyearsago")
    private int twoyearsago;

    public TotalMoneyInTheLast3Years(int  thisyear, int  lastyear, int  twoyearsago) {
        this.thisyear = thisyear;
        this.lastyear = lastyear;
        this.twoyearsago = twoyearsago;
    }

    public TotalMoneyInTheLast3Years() {
    }

    public int  getThisyear() {
        return thisyear;
    }

    public void setThisyear(int  thisyear) {
        this.thisyear = thisyear;
    }

    public int  getLastyear() {
        return lastyear;
    }

    public void setLastyear(int  lastyear) {
        this.lastyear = lastyear;
    }

    public int  getTwoyearsago() {
        return twoyearsago;
    }

    public void setTwoyearsago(int  twoyearsago) {
        this.twoyearsago = twoyearsago;
    }
}
