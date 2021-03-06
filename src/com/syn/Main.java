package com.syn;

import com.syn.builtinfunctions.function.AddThree;
import com.syn.builtinfunctions.unaryOperator.Person;
import com.syn.functionalinterface.FunctionalInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

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

        BinaryOperator<Integer> binaryOperator = (x, y) -> {
            x = x + y;
            return x;
        };

        Supplier<Integer> supplier = () -> (int) (Math.random() * 1000);

        Consumer<Integer> consumer = (v) -> System.out.println(v);
        consumer.accept(supplier.get());

        // Functional Composition Example
        Predicate<String> startsWithA = text -> text.startsWith("A");
        Predicate<String> endsWithX = text -> text.endsWith("X");

        Predicate<String> startsWithAAndEndsWithX =
                text -> startsWithA.test(text) && endsWithX.test(text);

        // Functional Composition Built-in Support
//        Predicate<String> composed = startsWithA.and(endsWithX);
        Predicate<String> composed = startsWithA.or(endsWithX);

        String input = "A text ending with X";
        boolean test = composed.test(input);
        System.out.println(test);

        // Function Composition
        Function<Integer, Integer> multiply = number -> number * 2;
        Function<Integer, Integer> add = number -> number + 3;

        Function<Integer, Integer> addThenMultiply = multiply.compose(add);
        Function<Integer, Integer> multiplyThenAdd = multiply.andThen(add);

        Integer value = multiplyThenAdd.apply(3);
        System.out.println(value);
    }
}
