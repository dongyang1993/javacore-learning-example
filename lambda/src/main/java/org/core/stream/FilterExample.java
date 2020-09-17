package org.core.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class FilterExample extends DataBase {

    @Test
    public void test() {
        List<Employee> collect = employeeList.stream()
                .filter(employee -> employee.getSalary() > 5000)
                .peek(System.out::println)
                .collect(Collectors.toList());

        Assertions.assertEquals(4, collect.size());

    }
}
