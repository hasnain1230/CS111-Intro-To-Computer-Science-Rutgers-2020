package edu.Rutgers.IntroToCS111.Assignment4;

/*************************************************************************
 *  Compilation:  javac RandomWalker.java
 *  Execution:    java RandomWalker 10
 *
 *  @author:Hasnain
 *
 * The program RandomWalker that takes an int command-line argument n
 * and simulates the motion of a random walk for n steps. Print the
 * location at each step (including the starting point), treating the
 * starting point as the origin (0, 0). Also, print the square of the
 * final Euclidean distance from the origin.
 *
 *  % java RandomWalker 10
 * (0,0)
 * (-1,0)
 * (-1,-1)
 * (-1,-2)
 * (-1,-3)
 * (-1,-4)
 * (-1,-5)
 * (0,-5)
 * (-1,-5)
 * (-2,-5)
 * (-2,-4)
 * Squared distance = 20.0
 *
 *************************************************************************/

public class RandomWalker {
    public static void main(String[] args) {
        int xCord = 0, yCord = 0;
        int randomDirection;

        System.out.printf("(%d,%d)\n", xCord, yCord);

        for (int moves = 0; moves < Integer.parseInt(args[0]); moves++) {
            randomDirection = (int) (Math.random() * 4);

            if (randomDirection == 0) yCord++;
            else if (randomDirection == 1) yCord--;
            else if (randomDirection == 2) xCord++;
            else if (randomDirection == 3) xCord--;

            System.out.printf("(%d,%d)\n", xCord, yCord);
        }

        System.out.printf("Square distance = %.1f", (Math.pow(xCord, 2) + Math.pow(yCord, 2)));
    }
}
