package com.webbanhang.jpa.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NamedStoredProcedureQuery(
        name = "getTotalMoneyInTheLast3Years",
        procedureName = "TotalMoneyInTheLast3Years"
)
public class TotalMoneyInTheLast3Years {

    @Id
    @Column(name = "Thisyear")
    private BigDecimal thisyear;

    @Column(name = "Lastyear")
    private BigDecimal lastyear;

    @Column(name = "Twoyearsago")
    private BigDecimal twoyearsago;

    public TotalMoneyInTheLast3Years(BigDecimal  thisyear, BigDecimal  lastyear, BigDecimal  twoyearsago) {
        this.thisyear = thisyear;
        this.lastyear = lastyear;
        this.twoyearsago = twoyearsago;
    }

    public TotalMoneyInTheLast3Years() {
    }

    public BigDecimal  getThisyear() {
        return thisyear;
    }

    public void setThisyear(BigDecimal  thisyear) {
        this.thisyear = thisyear;
    }

    public BigDecimal  getLastyear() {
        return lastyear;
    }

    public void setLastyear(BigDecimal  lastyear) {
        this.lastyear = lastyear;
    }

    public BigDecimal  getTwoyearsago() {
        return twoyearsago;
    }

    public void setTwoyearsago(BigDecimal  twoyearsago) {
        this.twoyearsago = twoyearsago;
    }
}
