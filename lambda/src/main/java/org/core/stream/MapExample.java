package org.core.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class MapExample extends DataBase {

    @Test
    public void test() {
        List<String> collect = employeeList.stream()
                .map(Employee::getName)
                .peek(System.out::println)
                .collect(Collectors.toList());

        Assertions.assertEquals(5, collect.size());
    }
}
