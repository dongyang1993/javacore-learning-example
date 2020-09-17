package org.core.stream;

import java.util.ArrayList;
import java.util.List;

public abstract class DataBase {

    List<Employee> employeeList = new ArrayList<>();
    {
        employeeList.add(new Employee(1, "Lily", 20, 5000));
        employeeList.add(new Employee(2, "Mike", 28, 8000));
        employeeList.add(new Employee(3, "Henry", 26, 9000));
        employeeList.add(new Employee(4, "Jack", 24, 6500));
        employeeList.add(new Employee(5, "Sherry", 20, 5500));
    }

    List<List<Employee>> flatMapList = new ArrayList<>();
    {
        List<Employee> employeeList1 = new ArrayList<>();
        employeeList1.add(new Employee(1, "Lily", 20, 5000));
        employeeList1.add(new Employee(2, "Mike", 28, 8000));

        List<Employee> employeeList2 = new ArrayList<>();
        employeeList2.add(new Employee(3, "Henry", 26, 9000));
        employeeList2.add(new Employee(4, "Jack", 24, 6500));
        employeeList2.add(new Employee(5, "Sherry", 23, 5500));

        flatMapList.add(employeeList1);
        flatMapList.add(employeeList2);
    }

}
