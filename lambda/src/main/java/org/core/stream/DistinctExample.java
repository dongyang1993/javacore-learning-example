package org.core.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DistinctExample extends DataBase {

    @Test
    public void test1() {
        List<Employee> collect = employeeList.stream().distinct().peek(System.out::println).collect(Collectors.toList());
        Assertions.assertEquals(5, collect.size());
    }

    @Test
    public void test2() {
        List<Employee> collect = employeeList.stream().filter(distinctByAge(Employee::getAge)).peek(System.out::println).collect(Collectors.toList());
        Assertions.assertEquals(4, collect.size());
    }

    private static <T> Predicate<T> distinctByAge(Function<? super T, ?> value) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(value.apply(t), Boolean.TRUE) == null;
    }
}
