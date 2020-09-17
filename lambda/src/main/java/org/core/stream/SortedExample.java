package org.core.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedExample extends DataBase {

    @Test
    public void test() {
        List<Employee> collect = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
//                .sorted((o1, o2) -> o1.getSalary() - o2.getSalary())
                .peek(System.out::println)
                .collect(Collectors.toList());

        Assertions.assertEquals(collect.get(0).getSalary(), 5000);
    }
}
