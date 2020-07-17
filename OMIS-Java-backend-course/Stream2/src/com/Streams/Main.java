package com.Streams;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
//        List<String> bingoNumbers = Arrays.asList("B7", "B14", "I20", "I25", "N35", "G50", "G51", "G52", "O70");
//
//        List<String> gNumbers = new ArrayList<>();
//
//        bingoNumbers.forEach(number -> {
//            if (number.startsWith("G")) {
//                gNumbers.add(number);
//                System.out.println("forEach " + number);
//            }
//        });
//
////        System.out.println("forEach: " + gNumbers);
//
//        bingoNumbers.stream()
//                .filter(e -> e.startsWith("G"))
//                .sorted()
//                .collect(Collectors.toCollection(()->gNumbers))
//                .forEach(System.out::println);
//
//        System.out.println("After stream " + gNumbers);
//        System.out.println("After stream " + bingoNumbers);

        IntStream.of(2,6,7,8)
                .map(e -> e * e)
                .filter(e -> e < 40)
                .forEach(System.out::println);

        IntStream.range(1, 5)
                .mapToDouble(e -> Math.pow(e, 2))
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);

        int first = IntStream.range(1,10).findFirst().getAsInt();
        int max = IntStream.of(1,10,1000,10000000).max().getAsInt();

        System.out.println(first);
        System.out.println(max);

        boolean allMatch = IntStream.of(1,10,5,5,3,2,6,8,9,112,3,4,46).allMatch(e -> e<11);
        System.out.println(allMatch);

        boolean anyMatch = IntStream.of(1,10,5,5,3,2,6,8,9,112,3,4,46).allMatch(e -> e%2 == 0);
        System.out.println(anyMatch);

    }
}
