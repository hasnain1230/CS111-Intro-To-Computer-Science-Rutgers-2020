package edu.Rutgers.IntroToCS111.Assignment5;

import java.awt.*;

/*************************************************************************
 *  Compilation:  javac Sierpinski.java
 *  Execution:    java Sierpinski
 *
 *  @author:Hasnain
 *
 *************************************************************************/

public class Sierpinski {

    // Height of an equilateral triangle whose sides are of the specified length.
    public static double height(double length) {
        return Math.sqrt(3) * (length / 2);
    }

    // Draws a filled equilateral triangle whose bottom vertex is (x, y)
    // of the specified side length.
    public static void filledTriangle(double x, double y, double length) {
        double[] xCord = {x, x + length / 2, x - length / 2};
        double[] yCord = {y, y + height(length), y + height(length)};
        StdDraw.filledPolygon(xCord, yCord);
    }
    // Draws a Sierpinski triangle of order n, such that the largest filled
    // triangle has bottom vertex (x, y) and sides of the specified length.
    public static void sierpinski(int n, double x, double y, double length) {
        double[] xCord = {x, x + length / 2, x - length / 2};
        double[] yCord = {y, y + height(length), y + height(length)};

        // When n == 0, that is the base case. Do nothing when it is equal to zero. Otherwise, draw a ton of triangles!
        if (n == 0) {
            return;
        } else {
            filledTriangle(x, y, length);
            sierpinski(n - 1, xCord[2], yCord[0], length / 2);
            sierpinski(n - 1, xCord[1], yCord[0], length / 2);
            sierpinski(n - 1, xCord[0], yCord[1], length / 2);

        }
    }

    // Takes an integer command-line argument n;
    // draws the outline of an equilateral triangle (pointed upwards) of length 1;
    // whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and
    // draws a Sierpinski triangle of order n that fits snugly inside the outline.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.polygon(new double[] {0, 1, 0.5}, new double[]{0, 0, Math.sqrt(3) * 0.5});
        sierpinski(n, 0.5, 0, 0.5);
    }
}
