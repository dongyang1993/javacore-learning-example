package org.core.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorExample extends DataBase {

    @Test
    public void test() {
        String collect = employeeList.stream().map(Employee::getName).collect(Collectors.joining(";", "[", "]"));

        List<String> list = employeeList.stream().map(Employee::getName).collect(Collectors.toList());

        Set<String> set = employeeList.stream().map(Employee::getName).collect(Collectors.toSet());

        ArrayList<String> arr = employeeList.stream().map(Employee::getName).collect(Collectors.toCollection(ArrayList::new));

        Map<String, Integer> map = employeeList.stream().collect(Collectors.toMap(Employee::getName, Employee::getAge));

        System.out.println("");

    }

}
