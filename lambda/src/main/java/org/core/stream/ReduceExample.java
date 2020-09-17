package org.core.stream;

import org.junit.jupiter.api.Test;

public class ReduceExample extends DataBase {

    @Test
    public void test() {
        int sum = employeeList.stream().mapToInt(Employee::getSalary).reduce(Integer::sum).orElse(0);
        System.out.println(sum);
    }
}
