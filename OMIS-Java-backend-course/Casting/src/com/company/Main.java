package com.company;

public class Main {

    public static void main(String[] args) {

        // Short harjutused


        byte byteNr = 1;
        byte byteMax = Byte.MAX_VALUE;
        short shrt =  7;
        int integerNr = 1000000;
        byte integerShrt = 10;
        float floatNr = 10;

        int fromByte = byteNr;


        byte fromIntShrt = (byte)integerShrt;
        byte fromIntLong = (byte)integerNr;
        System.out.printf("%n" + byteMax);
        //System.out.printf("%n" + fromIntLong);

        //System.out.printf("%n" + byteMax);

        //System.out.printf("%n" + byteMax+200);

        int fromFloatToInt = (int) floatNr;
        System.out.printf("%n" + fromFloatToInt);

        double fromFloatToDouble = (double) floatNr;
        System.out.printf("%n" + fromFloatToDouble);


        String stringNum = "123";
        int strToInt = Integer.parseInt(stringNum);
        String numToStr = String.valueOf(strToInt);
        System.out.printf("%n" + strToInt);
        System.out.printf("%n" + numToStr);

    }
}
