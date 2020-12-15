package com.mir.algorithms.commonproblems;

import java.util.LinkedList;

public class PalindromeStackImpl {

    public static boolean checkForPalindrome(String string) {

        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder lowercase = new StringBuilder(string.toLowerCase().replaceAll("[^a-zA-Z0-9]", ""));


//        System.out.println(lowercase);

        for (int i = 0; i < lowercase.length() ; i++){
            stack.push(lowercase.charAt(i));
        }

        StringBuilder reversedString = new StringBuilder(stack.size());

        //create reveres string
        while (!stack.isEmpty()) reversedString.append(stack.pop());

        return lowercase.toString().equals(reversedString.toString());
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
