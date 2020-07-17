package com.Interfaces;

public class EstPersonalCode implements PersonalCode {

    String ik = "38005051234";

    public void setIk(String ik) {
        this.ik = ik;
    }

    public EstPersonalCode(String ik) {
        this.ik = ik;
    }

    @Override
    public String getSugu() {
        String firstNum = this.ik.substring(0,1);
        if (firstNum.equals("1") || firstNum.equals("3") || firstNum.equals("5") ) {
            return "mees";
        } else if (firstNum.equals("2") || firstNum.equals("4") || firstNum.equals("6")) {
            return "naine";
        }
        return "";
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

    @Override
    public String toString() {
        return "Eesti isikukood: " + "ik='" + ik + '\'';
    }
}
