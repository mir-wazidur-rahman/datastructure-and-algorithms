package com.mir.algorithms.commonproblems;

public class Palindrome {


    public static boolean isPalindrome(String s){

        int i = 0;
        int j = s.length()-1;
        int k = (i + j) / 2;

        while ( i<=k ){
            if (s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String inputStr = "madam";

        if (isPalindrome(inputStr)) System.out.println(inputStr + " is a palindrome");
        else System.out.println(inputStr + " isn't a palindrome");

    }

}
