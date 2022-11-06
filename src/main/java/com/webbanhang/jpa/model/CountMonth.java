package com.webbanhang.jpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CountMonth {
    @Id
    private int month;

    private long CountAmount;

    public CountMonth() {
    }

    public CountMonth(int month, long countAmount) {
        this.month = month;
        CountAmount = countAmount;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public long getCountAmount() {
        return CountAmount;
    }

    public void setCountAmount(long countAmount) {
        CountAmount = countAmount;
    }
}
