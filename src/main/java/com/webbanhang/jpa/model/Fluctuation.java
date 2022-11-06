package com.webbanhang.jpa.model;

public class Fluctuation {
    private int present;
    private int total;
    private int inDe;
    private String ratio;

    public int getPresent() {
        return present;
    }

    public void setPresent(int present) {
        this.present = present;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getInDe() {
        return inDe;
    }

    public void setInDe(int inDe) {
        this.inDe = inDe;
    }
}
