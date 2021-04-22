package com.syn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("dsfsf");
        list.add("abc");
        list.add("bbb");

        Collections.sort(list, (a, b) -> {
            return a.compareTo(b);
        });

        Comparator<String> comparator = (a, b) -> {
            return a.compareTo(b);
        };

        Comparator<String> reversedComparator = comparator.reversed();

        Collections.sort(list, reversedComparator);

        System.out.println(list);
    }
}
