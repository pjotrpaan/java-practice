package com.Interfaces;

public class FinPersonalCode implements PersonalCode {

    String ik = "230181-237J";

    @Override
    public String getSugu() {
        int genNum = Integer.parseInt(this.ik.substring(9,10));
        if (genNum % 2 == 0) {
            return "mees";
        } else {
            return "naine";
        }
    }

    @Override
    public int getSynniAasta() {
        return 0;
    }

    @Override
    public String getSynniKuu() {
        return null;
    }

    @Override
    public int getSynnipaevaPaev() {
        return 0;
    }

    @Override
    public String getSynnipaevaKuu() {
        return null;
    }
}
