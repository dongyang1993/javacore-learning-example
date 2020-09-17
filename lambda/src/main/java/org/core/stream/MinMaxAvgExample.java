package org.core.stream;

import org.junit.jupiter.api.Test;

public class MinMaxAvgExample extends DataBase {

    @Test
    public void test() {
        int max = employeeList.stream().mapToInt(Employee::getSalary).max().orElse(0);
        int min = employeeList.stream().mapToInt(Employee::getSalary).min().orElse(0);
        int avg = (int) employeeList.stream().mapToInt(Employee::getSalary).average().orElse(0);

        System.out.println(max);
        System.out.println(min);
        System.out.println(avg);
    }
}
