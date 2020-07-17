package com.company;

import com.sun.source.tree.Tree;

import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        /*  LISTID  */
	    // AListi ja LListi vahe on see et AListi on parem kasutada elementide väljastamiseks ja sisestamiseks
        // LListi parem kasutada elementide asukoha muutmisek

        // Elemendid on mõlemal samas järjekorras nagu sisestamisel

        // Kui ei oska valida, siis kasuta AListi
        // Kui on palju manipuleerimist, ehk järjekordade vahetust kasuta LListi



        /*  SETID  */
        // Hoiavad ühekordseid andmeid

        // HashSet: unikaalsed elemendid suvalises järjekorras
        // LinkedSet: unikaalsed elemendid sisestatud järjekorras
        // TreeSet: unikaalsed elemendid (numbrilised väärtused kasvaval või kahanevallt


        /*  MAPID  */
        // HashMap
        // LinkedMap
        // TreeMap

        Map<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1,2);
        treeMap.put(3,4);
        treeMap.put(5,6);

        treeMap.entrySet().forEach(entry-> {
            System.out.printf(entry.getKey() + " " + entry.getValue() + "%n");
        });

        treeMap.entrySet().forEach(entry-> {
            System.out.printf(entry.getKey() + "%n");
        });

        System.out.println(treeMap.values().toArray()[1]);
        System.out.println(treeMap.get(3));
    }
}
