package com.webbanhang.jpa.model;

import java.util.List;

public class CharIn {
    private int charMonth[];
    private int countMonth[];
    private Object charYear;
    private int orderStatus[];

    public int[] getCharMonth() {
        return charMonth;
    }

    public void setCharMonth(int[] charMonth) {
        this.charMonth = charMonth;
    }

    public int[] getCountMonth() {
        return countMonth;
    }

    public void setCountMonth(int[] countMonth) {
        this.countMonth = countMonth;
    }

    public Object getCharYear() {
        return charYear;
    }

    public void setCharYear(Object charYear) {
        this.charYear = charYear;
    }

    public int[] getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int[] orderStatus) {
        this.orderStatus = orderStatus;
    }
}
