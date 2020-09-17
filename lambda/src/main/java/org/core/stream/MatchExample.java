package org.core.stream;

import org.junit.jupiter.api.Test;

public class MatchExample extends DataBase {

    @Test
    public void test() {
        //全部都满足才行
        boolean b1 = employeeList.stream().allMatch(employee -> employee.getAge() > 25);

        //只要有一个满足就行
        boolean b2 = employeeList.stream().anyMatch(employee -> employee.getAge() > 25);

        //一个都不满足才行
        boolean b3 = employeeList.stream().noneMatch(employee -> employee.getAge() < 18);

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }
}
