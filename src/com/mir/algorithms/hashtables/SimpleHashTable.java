package com.mir.algorithms.hashtables;

import com.mir.algorithms.abstractdatatypes.lists.Employee;

public class SimpleHashTable {

    private StoredEmployee[] hashtable;

    public SimpleHashTable(){
        hashtable = new StoredEmployee[10];
    }

    private int hashKey(String key){
        return key.length() % hashtable.length;
    }

    public void put(String key, Employee employee){
        int hashedKey = hashKey(key);

        if (occupied(hashedKey)){
            int stopIndex = hashedKey;

            if (hashedKey == hashedKey - 1){
                hashedKey = 0;
            }else{
                hashedKey++;
            }

            while (occupied(hashedKey) && hashedKey != stopIndex){
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if(occupied(hashedKey))
            System.out.println("Sorry there is already an employee at the position:" + hashedKey);
        else{
            hashtable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    public Employee get(String key){
        int hashedKey = findKey(key);

        if (hashedKey == -1){
            System.out.println("EMployee not found");
            return null;
        }

        return hashtable[hashedKey].employee;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);

        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }


        int stopIndex = hashedKey;

        if (hashedKey == hashedKey - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        while (hashedKey != stopIndex //all elements are traversed
                && hashtable[hashedKey] != null // should not be null
                && !hashtable[hashedKey].key.equals(key)) { // key not the one we want
            hashedKey = (hashedKey + 1) % hashtable.length;//keep looking
        }

      if (hashtable[hashedKey] != null
            && hashtable[hashedKey].key.equals(key)){
          return hashedKey;
      }else{
          return -1;
      }
    }

    private boolean occupied(int index) {
        return hashtable[index] != null;
    }

    public void printHashTable(){
        for (int i=0 ; i < hashtable.length ; i++) {
            if (null == hashtable[i]) System.out.println("empty");
            else
                System.out.println("Position: " + i + ":" + hashtable[i].employee);
        }
    }

    private Employee remove(String key){
        int hashedKey = findKey(key);

        if (hashedKey == -1) {
            System.out.println("Employee does not exist");
            return null;
        }

        Employee employee = hashtable[hashedKey].employee;
        hashtable[hashedKey] = null;
        StoredEmployee[] oldHashTable = hashtable;
        hashtable = new StoredEmployee[hashtable.length];

        for (int i=0 ; i < oldHashTable.length ; i++){
            if(oldHashTable[i] != null){
                put(oldHashTable[i].key,oldHashTable[i].employee);
            }
        }

        return employee;
    }

    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane", "Jones", 12);
        Employee johnDoe = new Employee("John", "Doe", 389);
        Employee mirRahman = new Employee("Mir", "Rahman", 3290);
        Employee nKumari = new Employee("Neha", "Kumari", 5830);
        Employee billEnd = new Employee("Bill", "End", 78);

        SimpleHashTable sht = new SimpleHashTable();
        sht.put("Jones",janeJones);
        sht.put("Doe",johnDoe);
        sht.put("Rahman",mirRahman);
        sht.put("end",billEnd);

        sht.printHashTable();

        System.out.println("Retrieving key Rahman :: " + sht.get("end"));

        System.out.println (sht.remove("Doe"));
        System.out.println (sht.remove("end"));

        sht.printHashTable();
    }
}
