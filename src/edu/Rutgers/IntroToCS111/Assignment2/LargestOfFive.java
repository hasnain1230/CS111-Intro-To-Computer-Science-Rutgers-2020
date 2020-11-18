package edu.Rutgers.IntroToCS111.Assignment2;

/*************************************************************************
 *  Compilation:  javac LargestOfFive.java
 *  Execution:    java LargestOfFive 35 10 32 1 8
 *
 *  @author: Hasnain Ali
 *
 *  Takes five distinct integers as command-line arguments and prints the 
 *  largest value
 *
 *
 *  % java LargestOfFive 35 10 32 1 8
 *  35
 *
 *  Assume the inputs are 5 distinct integers.
 *  Print only the largest value, nothing else.
 *
 *************************************************************************/

public class LargestOfFive {
    public static void main (String[] args) {
        int largest;
        int[] nums = new int[args.length];
        int index = 0;

        for (String input : args) {
            nums[index] = Integer.parseInt(input);
            index++;
        }

        largest = nums[0];

        for (int iterator = 1; iterator < args.length; iterator++) {
            if (nums[iterator] > largest) {
                largest = nums[iterator];
            }
        }

        System.out.println(largest);
    }
}