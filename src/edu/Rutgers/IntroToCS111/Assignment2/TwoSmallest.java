package edu.Rutgers.IntroToCS111.Assignment2;

/*************************************************************************
 *  Compilation:  javac TwoSmallest.java
 *  Execution:    java TwoSmallest 1.1 6.9 0.3
 *
 *  @author: Hasnain Ali
 *
 *  The program TwoSmallest takes a set of double command-line
 *  arguments and prints the smallest and second-smallest number, in that
 *  order. It is possible for the smallest and second-smallest numbers to
 *  be the same (if the sequence contains duplicate numbers).
 *
 *  Note: display one number per line
 *
 *  % java TwoSmallest 17.0 23.0 5.0 1.1 6.9 0.3
 *  0.3
 *  1.1
 *
 *  % java TwoSmallest 17.0 23.0 5.0 1.1 6.9 0.3
 *  0.3
 *  0.3
 *************************************************************************/

public class TwoSmallest {
    public static void main(String[] args) {
        double small1, small2;
        double[] nums = new double[args.length];
        int index = 0, temp = 0;

        small1 = small2 = Double.MAX_VALUE;

        for (String input : args) {
            nums[index] = Double.parseDouble(input);
            index++;
        }

        for (int iterator = 0; iterator < nums.length; iterator++) {
            if (nums[iterator] < small1) {
                small2 = small1;
                small1 = nums[iterator];
            }
            else if (nums[iterator] < small2) {
                small2 = nums[iterator];
            }
        }

        System.out.println(small1 + "\n" + small2);
    }
}
