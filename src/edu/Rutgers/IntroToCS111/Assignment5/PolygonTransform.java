package edu.Rutgers.IntroToCS111.Assignment5;

/*************************************************************************
 *  Compilation:  javac PolygonTransform.java
 *  Execution:    java PolygonTransform
 *
 *  @author:
 *
 *************************************************************************/

public class PolygonTransform {


    // Returns a new array that is an exact copy of the given array. 
    // The given array is not mutated. 
    public static double[] copy(double[] array) {
        double[] copyArr = new double[array.length];

        for (int x = 0; x < array.length; x++) copyArr[x] = array[x];

        return copyArr;
    }
    
    // Scales the given polygon by the factor alpha. 
    public static void scale(double[] x, double[] y, double alpha) {
        // Scale x array
        for (int i = 0; i < x.length; i++) x[i] *= alpha;
        // Scale y array
        for (int j = 0; j < y.length; j++) y[j] *= alpha;
    }
    
    // Translates the given polygon by (dx, dy). 
    public static void translate(double[] x, double[] y, double dx, double dy) {
        // Translate x array
        for (int i = 0; i < x.length; i++) x[i] += dx;
        // Translate y array
        for (int j = 0; j < y.length; j++) y[j] += dy;
    }
    
    // Rotates the given polygon theta degrees counterclockwise, about the origin. 
    public static void rotate(double[] x, double[] y, double theta) {
        theta *= (Math.PI / 180); // Can use Math.toRadians
        double[] tempCopyX = copy(x);


        // Rotate x point
        for (int i = 0; i < x.length; i++) {
            x[i] = x[i] * Math.cos(theta) - y[i] * Math.sin(theta);
        }
        // Rotate y point
        for (int j = 0; j < y.length; j++) {
            y[j] = y[j] * Math.cos(theta) + tempCopyX[j] * Math.sin(theta);
        }
    }

    // Tests each of the API methods by directly calling them. 
    public static void main(String[] args) {
        // No client-side code written. It was removed for the purposes of the auto grader.
    }
}
