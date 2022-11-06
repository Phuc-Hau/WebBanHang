package com.webbanhang.jpa.model;

public class Statistical {
    private Fluctuation month;
    private Fluctuation year;
    private Fluctuation countpricemonth;
    public Fluctuation getMonth() {
        return month;
    }

    public void setMonth(Fluctuation month) {
        this.month = month;
    }

    public Fluctuation getYear() {
        return year;
    }

    public void setYear(Fluctuation year) {
        this.year = year;
    }

    public Fluctuation getCountpricemonth() {
        return countpricemonth;
    }

    public void setCountpricemonth(Fluctuation countpricemonth) {
        this.countpricemonth = countpricemonth;
    }
}
