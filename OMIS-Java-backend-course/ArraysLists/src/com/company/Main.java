package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<String> arrayList = new ArrayList(Arrays.asList("null", "nullkomaviis"));
        List<Integer> linkedList = new LinkedList();

        arrayList.add("esimene");

        arrayList.add("teine");

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.printf(arrayList.get(i) + "%n");
        }

        arrayList.remove(2);
        List<Object> sublist = arrayList.subList(1,2);

        for (Object o : arrayList) {
            System.out.printf(o + "%n");
        }

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        for (Integer integer : linkedList) {
            System.out.printf(integer + "%n");
        }

        // Sisu ei dubleerita
        HashSet<Boolean> hashSet = new HashSet();
        hashSet.add(true);
        hashSet.add(false);
        hashSet.add(false);
        hashSet.add(true);

        for (Object booleanValue:hashSet) {
            System.out.printf(booleanValue + "%n");
        }

        Map<Object, Integer> hashMap = new HashMap<>();

        hashMap.put("yts", 1);
        hashMap.put("kats", 2);
        hashMap.put("komm", 3);
        hashMap.put('1', 1);
        hashMap.put('2', 2);
        hashMap.put('3', 3);
        hashMap.put('3', 3);

        hashMap.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " " + entry.getValue());
        });

        System.out.println(hashMap);


    }
}
