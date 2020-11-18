package edu.Rutgers.IntroToCS111.Assignment4;

import java.util.Arrays;

/*************************************************************************
 *  Compilation:  javac RURottenTomatoes.java
 *  Execution:    java RURottenTomatoes
 *
 *  @author:Hasnain
 *
 * RURottenTomatoes creates a 2 dimensional array of movie ratings 
 * from the command line arguments and displays the index of the movie 
 * that has the highest sum of ratings.
 *
 *  java RURottenTomatoes 3 2 5 2 3 3 4 1
 *  0
 *************************************************************************/

public class RURottenTomatoes {
    public static void main(String[] args) {
        int currentElement = 0, bestRatingsIndex = 0, maxRatingsSum = 0;
        int[][] movieRatings = new int[Integer.parseInt(args[currentElement])][Integer.parseInt(args[++currentElement])];
        int[] ratingsSum = new int[Integer.parseInt(args[currentElement])];

        for (int reviewers = 0; reviewers < movieRatings.length; reviewers++) {
            for (int movies = 0; movies < movieRatings[reviewers].length; movies++) {
                currentElement++;
                movieRatings[reviewers][movies] = Integer.parseInt(args[currentElement]);
                ratingsSum[movies] += movieRatings[reviewers][movies];
            }
        }

        for (int largestElement = 0; largestElement < ratingsSum.length; largestElement++) {
            if (ratingsSum[largestElement] > maxRatingsSum) {
                maxRatingsSum = ratingsSum[largestElement];
                bestRatingsIndex = largestElement;
            }
        }
        
        System.out.println(bestRatingsIndex);
	}
}
