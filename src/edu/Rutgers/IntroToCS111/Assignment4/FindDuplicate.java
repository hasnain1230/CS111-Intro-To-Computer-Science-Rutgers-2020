package edu.Rutgers.IntroToCS111.Assignment4;

/*************************************************************************
 *  Compilation:  javac FindDuplicate.java
 *  Execution:    java FindDuplicate
 *
 *  @author:Hasnain
 *
 * FindDuplicate that reads n integer arguments from the command line 
 * into an integer array of length n, where each value is between is 1 and n, 
 * and displays true if there are any duplicate values, false otherwise.
 *
 *  % java FindDuplicate 10 8 5 4 1 3 6 7 9
 *  false
 *
 *  % java FindDuplicate 4 5 2 1 
 *  true
 *************************************************************************/

public class FindDuplicate {
    public static void main(String[] args) {
        /*
        A hash map could be used for this program to have a time complexity of O(n), however, I think the expectation here
        is to take an elementary approach here and have time complexity be O(n^2).
        */

        int[] arguments = new int[args.length];
        boolean duplicate = false;

        for (int values = 0; values < args.length; values++) {
            arguments[values] = Integer.parseInt(args[values]);
        }
        
        outerloop:
        for (int x = 0; x < arguments.length; x++) {
            for (int y = x + 1; y < arguments.length ; y++) {
                if (arguments[x] == arguments[y]) {
                    duplicate = true;
                    break outerloop;
                } else {
                    duplicate = false;
                }
            }
        }
        
        System.out.println(duplicate);
	}
}
