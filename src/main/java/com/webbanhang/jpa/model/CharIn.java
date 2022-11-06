package com.webbanhang.jpa.model;

public class CharIn {
    private int charMonth[];
    private int countMonth[];
    private int charYear[];
    private int orderStatus[];

    public int[] getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int[] orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int[] getCountMonth() {
        return countMonth;
    }

    public void setCountMonth(int[] countMonth) {
        this.countMonth = countMonth;
    }

    public int[] getCharMonth() {
        return charMonth;
    }

    public void setCharMonth(int[] charMonth) {
        this.charMonth = charMonth;
    }

    public int[] getCharYear() {
        return charYear;
    }

    public void setCharYear(int[] charYear) {
        this.charYear = charYear;
    }
}
