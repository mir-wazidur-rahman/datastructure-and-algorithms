package com.mir.algorithms.abstractdatatypes.lists;

public class DoublyLinkedListImpl {

    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;

    public void addToFront(Employee employee){

        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);

        if (head == null) {
            tail = node;
        }else{
            head.setPrevious(node);
            node.setNext(head);
        }
        head = node;
        size++;
    }

    public void addToEnd(Employee employee){

        EmployeeNode node = new EmployeeNode(employee);

        if (tail == null) {
            head = node;
        }else{
            tail.setNext(node);
            node.setPrevious(tail);
        }
        tail = node;
        size++;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty() {
        return null == head;
    }



    public void printList(){
        EmployeeNode current = head;

        System.out.print("HEAD -> ");
        while(current != null){
            System.out.print(current);
            System.out.print(" <=> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public EmployeeNode removeFromFront(){

        if (isEmpty()) return null;

        EmployeeNode removedNode = head;

        //removing the only node from the list then tail has to be null
        if(head.getNext() == null){
            tail = null;
        }else{
            //here we are setting the previous field to null
            head.getNext().setPrevious(null);
        }
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;

    }

    public EmployeeNode removeFromEnd(){

        if (isEmpty()) return null;

        EmployeeNode removedNode = tail;

        if(tail.getPrevious() == null){
            head = null;
        }else{
            tail.getPrevious().setNext(null);
        }
         tail = tail.getPrevious();


        removedNode.setPrevious(null);
        size--;
        return removedNode;

    }

    public boolean addBefore(Employee existingEmployee, Employee newEmployee){
        /**
         * return true if you successfully added the employee,
         * else return false if the existing employee does not exist
         */

        if (isEmpty()) return false;

        //Find the existing employee
        EmployeeNode current = head;

        //looping to find the employee
        while(null != current && !current.getEmployee().equals(existingEmployee)){
            current = current.getNext();
        }

        if (null == current) {
            return false;
        }else{
            //setting the pointers
            EmployeeNode newNode = new EmployeeNode(newEmployee);
            newNode.setPrevious(current.getPrevious());
            newNode.setNext(current);
            current.setPrevious(newNode);

            //if the existing employee is at head position
            if(head == current){
                head = newNode;
            }else{
                //if the existing employee is in middle
                newNode.getPrevious().setNext(newNode);
            }
            size++;

            return true;
        }



    }

    public static void main(String[] args) {

        Employee janeJones =  new Employee("Jane","Jones",123);
        Employee johnDoe = new Employee("John","Doe",4567);
        Employee maryJane = new Employee("Mary","Jane",22);
        Employee mirWazidur = new Employee("Mir","Wazidur",319023);

        DoublyLinkedListImpl list = new DoublyLinkedListImpl();
        System.out.println(list.isEmpty());

        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(mirWazidur);
        list.addToFront(maryJane);


        list.printList();
        System.out.println(list.getSize());

        Employee billEnd = new Employee("Bill" , "End", 78);
        list.addToEnd(billEnd);
        list.printList();
        System.out.println(list.getSize());

        System.out.println("After removing first element");
        list.removeFromFront();
        list.printList();
        System.out.println(list.getSize());

        System.out.println("After removing last element");
        list.removeFromEnd();
        list.printList();
        System.out.println(list.getSize());

        Employee nehaKumari = new Employee("Neha","Kumari",545211);
        list.addBefore(mirWazidur,nehaKumari);
        System.out.println("Adding Neha before john");
        list.printList();
        System.out.println(list.getSize());


    }
}
