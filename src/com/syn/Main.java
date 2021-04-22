package com.syn;

import com.syn.buildinfunctions.function.AddThree;
import com.syn.buildinfunctions.unaryOperator.Person;
import com.syn.functionalinterface.FunctionalInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

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

        FunctionalInterface lambda = () -> {
            System.out.println("Executing...");
        };

        lambda.execute();

        Function<Long, Long> function = new AddThree();
        Long result = function.apply(4L);
        System.out.println(result);

        Function<Long, Long> lambdaFunction = (v) -> v + 3;
        Long lambdaResult = lambdaFunction.apply(4L);
        System.out.println(lambdaResult);

        Predicate predicate = (v) -> v != null;

        UnaryOperator<Person> unaryOperator = person -> {
            person.setName("John");
            return person;
        };
    }
}
