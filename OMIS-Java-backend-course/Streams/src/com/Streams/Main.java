package com.Streams;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
//        PrintWriter printWriter = new PrintWriter("src/com/Streams/new_data.txt");

        PrintWriter printWriter = new PrintWriter(System.in);
//        Files.readAllLines(Paths.get("src/com/Streams/data.txt")).stream()
//                .map(e -> e.split(" "))
//                .filter(e -> Integer.parseInt(e[0]) < 5)
//                .map(e -> e[0] + " " + e[1])
//                .forEach(printWriter::println);
//        printWriter.close();
        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//        List<Integer> intList2 = intList.stream()
//                .filter(e -> e <5)
//                .collect(Collectors.toList());
//
//        for (Integer i : intList2) {
//            System.out.println(i);
//        }

//        List<Integer> intList3 = intList.stream()
//                .map(e -> e * 2)
//                .peek(System.out::println)
//                .collect(Collectors.toList());
//        List<Integer> intList3 = intList.stream()
//                .map(e -> e * 2)
//                .peek(printWriter::println)
//                .collect(Collectors.toList());

        List<Integer> intList3 = intList.stream()
                .map(e -> e * 2)
                .skip(2)
                .limit(2)
                .peek(printWriter::println)
                .collect(Collectors.toList());

        for (Integer i : intList3) {
            System.out.println(i);
        }
        printWriter.close();
    }
}
