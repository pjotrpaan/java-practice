package com.Interfaces;

public class SwePersonalCode implements PersonalCode {
    String ik;

    public SwePersonalCode(String ik) {
        this.ik = ik;
    }

    @Override
    public String getSugu() {
        int genNum = Integer.parseInt(this.ik.substring(10,11));
        if (genNum % 2 == 0) {
            return "Naine";
        } else {
            return "Mees";
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
