package com.mir.algorithms.abstractdatatypes.lists;

import java.util.NoSuchElementException;

public class ArrayQueue {

    private Employee[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity){
        queue = new Employee[capacity];
    }

    public void add(Employee employee){

        if (back == queue.length){
            Employee[] newArray = new Employee[2 * queue.length];
            System.arraycopy(queue,0,newArray,0,queue.length);
            queue =  newArray;
        }

        queue[back++] = employee;
    }

    public Employee remove(){
        if (size() == 0) throw new NoSuchElementException();

        Employee employee = queue[front];
        queue[front] = null;
        front++;
        //removed the last employee
        if(size() == 0) front = back =0;

        return employee;
    }

    public Employee peek(){

        if(size() == 0) throw new NoSuchElementException();

        return queue[front];
    }

    public int size(){
        return (back - front);
    }

    public void printQueue(){
        for (int i = front; i < back ; i++){
            System.out.println(queue[i]);
        }
    }

    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane", "Jones", 12);
        Employee johnDoe = new Employee("John", "Doe", 389);
        Employee mirRahman = new Employee("Mir", "Rahman", 3290);
        Employee nKumari = new Employee("Neha", "Kumari", 5830);
        Employee billEnd = new Employee("Bill", "End", 78);

        ArrayQueue queue = new ArrayQueue(10);
        queue.add(janeJones);
        queue.add(johnDoe);
        queue.add(mirRahman);
        queue.add(nKumari);
        queue.add(billEnd);

//        queue.printQueue();

        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
//        queue.remove();
        queue.printQueue();

        queue.add(mirRahman);

//        System.out.println(queue.peek());

    }

}
