package com.mir.algorithms.hashtables;

import com.mir.algorithms.abstractdatatypes.lists.Employee;

import java.util.*;

public class HashTableChallenge {

    private static Map<Integer,Employee> removeDuplicates(List<Employee> employees){
        Map<Integer,Employee> hashMap = new HashMap<>();

        ListIterator<Employee> itr = employees.listIterator();
        List<Employee> remove = new ArrayList<>();

        while (itr.hasNext()){
            Employee employee = itr.next();
                hashMap.put(employee.getId(), employee);


        }

//        for (Employee employee : remove)
//            employees.remove(employee);

        return hashMap;
    }

    public static void main(String[] args) {

        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));



        employees.forEach(e -> System.out.println(e));

        System.out.println("=============After sorting===========");

        Map<Integer,Employee> reducedmap = removeDuplicates(employees);

        reducedmap.forEach((integer, employee) -> System.out.println(employee));


    }
}
