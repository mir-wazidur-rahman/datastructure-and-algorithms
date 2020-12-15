package com.mir.algorithms.abstractdatatypes.lists;

import java.util.LinkedList;
import java.util.ListIterator;

public class JDKLinkedListStackImpl {

    private LinkedList<Employee> stack;

    public JDKLinkedListStackImpl(){
        stack = new LinkedList<>();
    }

    public void push(Employee employee){
        stack.push(employee);
    }

    public Employee pop(){
        return stack.pop();
    }

    public Employee peek(){
        return stack.peek();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void printStack(){
        ListIterator<Employee> iterator = stack.listIterator();

        while (iterator.hasNext()) System.out.println(iterator.next());
    }



    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane", "Jones", 12);
        Employee johnDoe = new Employee("John", "Doe", 389);
        Employee mirRahman = new Employee("Mir", "Rahman", 3290);
        Employee nKumari = new Employee("Neha", "Kumari", 5830);
        Employee billEnd = new Employee("Bill", "End", 78);

        JDKLinkedListStackImpl stack = new JDKLinkedListStackImpl();
        stack.push(janeJones);
        stack.push(johnDoe);
        stack.push(mirRahman);
        stack.push(nKumari);
        stack.push(billEnd);

//        stack.printStack();

        System.out.println(stack.pop());
        System.out.println(stack.peek());

    }
}
