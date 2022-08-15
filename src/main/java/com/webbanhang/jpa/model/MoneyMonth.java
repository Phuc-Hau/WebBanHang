package com.webbanhang.jpa.model;


import javax.persistence.*;

@Entity
public class MoneyMonth{

    @Id
    private int month;

    private double money;

    public MoneyMonth() {

    }
    public MoneyMonth(int month, double money) {
        this.month = month;
        this.money = money;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
