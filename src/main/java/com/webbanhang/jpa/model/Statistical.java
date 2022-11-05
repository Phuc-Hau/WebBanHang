package com.webbanhang.jpa.model;

import java.util.Arrays;

public class Statistical {
    private String month;
    private String year;
    private int sumpricemonth;
    private int sumcount;
    private int sumpriceyear;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getSumpricemonth() {
        return sumpricemonth;
    }

    public void setSumpricemonth(int sumpricemonth) {
        this.sumpricemonth = sumpricemonth;
    }

    public int getSumcount() {
        return sumcount;
    }

    public void setSumcount(int sumcount) {
        this.sumcount = sumcount;
    }

    public int getSumpriceyear() {
        return sumpriceyear;
    }

    public void setSumpriceyear(int sumpriceyear) {
        this.sumpriceyear = sumpriceyear;
    }


}
