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

        if (size() == queue.length - 1){
            int numItems = size();// saving to reset the back after unwrapping the queue
            Employee[] newArray = new Employee[2 * queue.length];
            //unwrapping the queue
            System.arraycopy(queue,front,newArray,0,queue.length - front);
            System.arraycopy(queue,0,newArray,queue.length - front,back);
            queue =  newArray;
            front = 0;
            back = numItems;
        }

        queue[back] = employee;
        //checking if there is any room in the queue to increase back side
        if (back < queue.length - 1) back++;
        else  back = 0;//setting back to front, thus making it a circular queue
    }

    public Employee remove(){
        if (size() == 0) throw new NoSuchElementException();

        Employee employee = queue[front];
        queue[front] = null;
        front++;

        //removed the last employee
        if(size() == 0) {
            front = back =0;
        }else if(front == queue.length){
            front = 0;
        }

        return employee;
    }

    public Employee peek(){

        if(size() == 0) throw new NoSuchElementException();

        return queue[front];
    }

    public int size(){

        //queue is not wrapped yet
        if (front <=  back)  return (back - front);

        else return (back - front + queue.length);
    }

    public void printQueue(){

        //printing unwrapped queue
        if (front <= back){
            for (int i = front; i < back ; i++){
                System.out.println(queue[i]);
            }
        }
        else{
            //printing front to end of queue length
            for (int i = front ; i < queue.length ; i++) System.out.println(queue[i]);

            //printing from 0th element to back
            for (int i = 0; i < back ; i++) System.out.println(queue[i]);
        }

    }

    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane", "Jones", 12);
        Employee johnDoe = new Employee("John", "Doe", 389);
        Employee mirRahman = new Employee("Mir", "Rahman", 3290);
        Employee nKumari = new Employee("Neha", "Kumari", 5830);
        Employee billEnd = new Employee("Bill", "End", 78);

        ArrayQueue queue = new ArrayQueue(5);
        queue.add(janeJones);
        queue.add(johnDoe);
        queue.add(mirRahman);
        queue.add(nKumari);
        queue.add(billEnd);
        queue.add(janeJones);

        queue.printQueue();




//        System.out.println(queue.peek());

    }

}
