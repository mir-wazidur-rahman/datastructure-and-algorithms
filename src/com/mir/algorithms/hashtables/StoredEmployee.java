package com.mir.algorithms.hashtables;

import com.mir.algorithms.abstractdatatypes.lists.Employee;

public class StoredEmployee {

    public String key;//raw key not hashed value
    public Employee employee;

    public StoredEmployee(String key, Employee employee) {
        this.key = key;
        this.employee = employee;
    }
}
