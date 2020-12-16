package com.mir.algorithms.hashtables;

import com.mir.algorithms.abstractdatatypes.lists.Employee;
import sun.security.mscapi.CPublicKey;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ChainedHashTable {

    private LinkedList<StoredEmployee>[] hashtable;

    public ChainedHashTable(){
        hashtable = new LinkedList[10];
        for (int i = 0; i < hashtable.length ; i++){
            hashtable[i] = new LinkedList<>();
        }
    }

    public void put(String key, Employee employee){
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new StoredEmployee(key,employee));
    }

    private int hashKey(String key){
//        return key.length() % hashtable.length;

        return Math.abs(key.hashCode() % hashtable.length);
    }

    public Employee get(String key){

        int hashedKey = hashKey(key);

        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
        StoredEmployee employee = null;
        while (iterator.hasNext()){
            employee = iterator.next();
            if (employee.key.equals(key)){
                return employee.employee;
            }
        }

        return null;
    }

    public Employee remove(String key){

        int hashedKey = hashKey(key);

        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
        StoredEmployee employee = null;
        int index = -1;
        while (iterator.hasNext()){
            employee = iterator.next();
            index++;
            if (employee.key.equals(key)){
//                return employee.employee;
                break;
            }
        }

        if (employee == null) return null;
        else {
            hashtable[hashedKey].remove(index);
            return employee.employee;
        }

    }

    private void printHashTable(){
        for (int i = 0; i < hashtable.length ;  i++){
            if (hashtable[i] == null)
                System.out.println("Position " + i + ": empty");

            else {
                System.out.println("Position " +i+": ");
                ListIterator<StoredEmployee> iterator = hashtable[i].listIterator();
                while (iterator.hasNext()){
                    System.out.print(iterator.next().employee);
                    System.out.print("->");
                }
                System.out.println("NULL");
            }
        }
    }

    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane", "Jones", 12);
        Employee johnDoe = new Employee("John", "Doe", 389);
        Employee mirRahman = new Employee("Mir", "Rahman", 3290);
        Employee nKumari = new Employee("Neha", "Kumari", 5830);
        Employee billEnd = new Employee("Bill", "End", 78);

        ChainedHashTable cht = new ChainedHashTable();
        cht.put("Jones",janeJones);
        cht.put("Doe",johnDoe);
        cht.put("Rahman",mirRahman);
        cht.put("end",billEnd);

//        cht.remove("Doe");

        cht.printHashTable();


    }

}
