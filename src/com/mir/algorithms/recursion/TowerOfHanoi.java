package com.mir.algorithms.recursion;

public class TowerOfHanoi {

    public static void solve(int disk, char source, char aux, char destination){

        if (disk == 0){
            System.out.println("Plate " + disk + " from " + source + " to " + destination);
            return;
        }

        /**
         * Our goal is to mov1 n-1 disks to middle rod to be able to move the last disk to final rod
         */

        //we move n-1 disks to aux from source using destination
        solve(disk-1 , source, destination , aux);

        System.out.println("Plate " + disk + " from " + source + " to " + destination);
        //we move the largest plate to destination from source
        solve(disk-1 , aux, source , destination);
    }

    public static void main(String[] args) {
        solve(3,'A','B','C');
    }
}
