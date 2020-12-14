package com.mir.algorithms.abstractdatatypes.lists;



import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Jane","Jones",123));
        employeeList.add(new Employee("John","Doe",4567));
        employeeList.add(new Employee("Mary","Jane",22));
        employeeList.add(new Employee("Mir","Wazidur",319023));

        System.out.println("Before change :: ");
        employeeList.forEach(employee -> System.out.println(employee));

        System.out.println(employeeList.get(1));//time complexity is constant

        System.out.println(employeeList.isEmpty());

        //replace employee
        employeeList.set(1, new Employee("Neha","Kumari", 565421));

        System.out.println("After change");
        employeeList.forEach(employee -> System.out.println(employee));

        //adding employee at a fixed position
        employeeList.add(3, new Employee("John","Doe",4567));
        employeeList.forEach(employee -> System.out.println(employee));

        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
        System.out.println("Employee array :: ");

        for (Employee employee : employeeArray) System.out.println(employee);

        System.out.println(employeeList.contains( new Employee("Mir", "Wazidur", 319023)));

        System.out.println(employeeList.indexOf(new Employee("Mir", "Wazidur", 319023)));

        employeeList.remove(1);
        employeeList.forEach(employee -> System.out.println(employee));

    }
}
