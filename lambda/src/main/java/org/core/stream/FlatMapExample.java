package org.core.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample extends DataBase {

    @Test
    public void test() {
        List<Employee> collect = flatMapList.stream()
                .flatMap(Collection::stream)
                .peek(System.out::println)
                .collect(Collectors.toList());

        Assertions.assertEquals(employeeList.size(), collect.size());
    }
}
