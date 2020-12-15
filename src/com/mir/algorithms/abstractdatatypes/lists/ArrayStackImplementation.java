package com.mir.algorithms.abstractdatatypes.lists;

import java.util.EmptyStackException;

public class ArrayStackImplementation {



        private Employee[] stack;
        private int top;
        public ArrayStackImplementation(int capacity){
            stack = new Employee[capacity];

        }

    public void push(Employee employee){
            if(top == stack.length){
                // need to resize
                Employee[] newArray = new Employee[2 * stack.length];
                System.arraycopy(stack,0,newArray,0,stack.length);
                stack = newArray;
            }

            stack[top++] = employee;
    }

    public Employee pop(){

            if (isEmpty()){
                throw new EmptyStackException();
            }

            Employee employee = stack[--top];
            stack[top] =  null;  //removing the top element
            return employee;
    }

    public boolean isEmpty(){
            return top == 0;
    }

    public Employee peek(){

            if (isEmpty()) throw new EmptyStackException();

            return stack[top - 1];
    }

    public int size(){
            return top;
    }

    public void printStack(){

            for (int i = top - 1; i >= 0 ; i--) System.out.println(stack[i]);
    }

    public static void main(String[] args) {
        ArrayStackImplementation stack = new ArrayStackImplementation(10);
        stack.push(new Employee("Jane", "Jones", 12));
        stack.push(new Employee("John", "Doe", 389));
        stack.push(new Employee("Mir", "Rahman", 3290));
        stack.push(new Employee("Neha", "Kumari", 5830));
        stack.push(new Employee("Bill", "End", 78));

//        stack.printStack();

        System.out.println(stack.peek());

        System.out.println("Popped :: " + stack.pop());

        System.out.println(stack.peek());

        System.out.println(stack.size());

    }
}
