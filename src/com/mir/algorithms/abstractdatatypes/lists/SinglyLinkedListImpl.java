package com.mir.algorithms.abstractdatatypes.lists;

public class SinglyLinkedListImpl {

    private EmployeeNode head;
    private int size;

    public void addToFront(Employee employee){
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;
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
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public EmployeeNode removeFromFront(){

        if (isEmpty()) return null;

        EmployeeNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;

    }

    public static void main(String[] args) {

        Employee janeJones =  new Employee("Jane","Jones",123);
        Employee johnDoe = new Employee("John","Doe",4567);
        Employee maryJane = new Employee("Mary","Jane",22);
        Employee mirWazidur = new Employee("Mir","Wazidur",319023);

        SinglyLinkedListImpl list = new SinglyLinkedListImpl();
        System.out.println(list.isEmpty());

        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(maryJane);
        list.addToFront(mirWazidur);

        list.printList();
        System.out.println(list.getSize());

        list.removeFromFront();
        System.out.println();
        System.out.println(list.getSize());
        list.printList();


    }
}
