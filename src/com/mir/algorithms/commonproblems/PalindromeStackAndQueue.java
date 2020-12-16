package com.mir.algorithms.commonproblems;

import java.util.LinkedList;

public class PalindromeStackAndQueue {


    private static boolean checkForPalindrome(String string) {

        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> queue = new LinkedList<>();

        StringBuilder lowercase = new StringBuilder(string.toLowerCase().replaceAll("[^a-zA-Z0-9]", ""));

        for (int i = 0; i < lowercase.length() ; i++){
            stack.push(lowercase.charAt(i));
            queue.add(lowercase.charAt(i));
        }

        for (int i = 0; i < stack.size() ; i++){
            if (!stack.get(i).toString().equals(queue.get(i).toString()))
                return false;
        }

        return true;




    }


    public static void main(String[] args) {

        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));

    }


}
