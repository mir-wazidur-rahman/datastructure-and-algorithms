package com.mir.algorithms.abstractdatatypes.lists;

import java.util.Iterator;
import java.util.LinkedList;

public class JDKLinkedListExample {

    public static void main(String[] args) {

        Employee janeJones =  new Employee("Jane","Jones",123);
        Employee johnDoe = new Employee("John","Doe",4567);
        Employee maryJane = new Employee("Mary","Jane",22);
        Employee mirWazidur = new Employee("Mir","Wazidur",319023);

        LinkedList<Employee> list = new LinkedList<>();

        list.addFirst(janeJones);
        list.addFirst(johnDoe);
        list.addFirst(mirWazidur);
        list.addFirst(maryJane);

        printList(list);
        System.out.println(list.size());

        Employee nKumari = new Employee("Neha","Kumari",319023);
        list.add(nKumari);
        System.out.println("After adding element in the last");
        printList(list);
        System.out.println(list.size());

        list.remove();//same as removeFirst
        System.out.println("After removing first element");
        printList(list);
        System.out.println(list.size());


    }

    private static void printList(LinkedList list){

        Iterator iter = list.iterator();
        System.out.print("HEAD->");
        while (iter.hasNext()) {
            System.out.print(iter.next());
            System.out.print("<=>");
        }
        System.out.println("null");
    }
}
