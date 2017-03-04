package com.sumeeth.webapp.data.dto;

/**
 * Created by daljit on 29-Jan-17.
 */
public class Option {


    private String A;
    private String B;
    private String C;
    private String D;

    public String getA() {
        return A;
    }

    public void setA(String A) {
        this.A = A;
    }

    public String getB() {
        return B;
    }

    public void setB(String B) {
        this.B = B;
    }

    public String getC() {
        return C;
    }

    public void setC(String C) {
        this.C = C;
    }

    public String getD() {
        return D;
    }

    public void setD(String D) {
        this.D = D;
    }


    @Override
    public String toString() {
        return "{" +
                "A='" + A + '\'' +
                ",B='" + B + '\'' +
                ",C='" + C + '\'' +
                ",D='" + D + '\'' +
                '}';
    }
}
