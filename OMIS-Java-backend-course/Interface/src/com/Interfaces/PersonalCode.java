package com.Interfaces;

public interface PersonalCode {
    String getSugu();
    int getSynniAasta();
    String getSynniKuu();
    int getSynnipaevaPaev();
    String getSynnipaevaKuu();
    default boolean isHuman() {
        return true;
    }
}
