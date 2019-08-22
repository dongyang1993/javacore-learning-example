package org.core.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample1 {
    public static void main(String[] args) {
        example1();
    }

    public static void example1() {
        String str = "Lexington’s visit was spurred by the latest evidence that young people in America";
        Stream<String> words = Stream.of(str.split(" "));
        List<Integer> collect = words.map(String::length).collect(Collectors.toList());
        System.out.println(collect.toArray());
    }
}
