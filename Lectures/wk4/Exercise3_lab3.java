/* jaroblestos@miners.utep.edu */

package Lectures.wk4;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

class Exercise3_lab3 {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(3, 5);
        Rectangle rect2 = new Rectangle(3, 9);
        Rectangle rect3 = new Rectangle(4, 10);

        Rectangle[] rects = new Rectangle[3];
        rects[0] = rect1;
        rects[1] = rect2;
        rects[2] = rect3;

        printAllRectanglesArea(rects);

        int small_rect_i = smallestRect(rects);
        System.out.println("Smallest rect index: " + small_rect_i);

        int largest_rect_i = largestRect(rects);
        System.out.println("Largest rect index: " + largest_rect_i);

        double max_square_side = maxSqure(rects[largest_rect_i]);
        System.out.println("Largest square that can fit in Largest rectangle: " + max_square_side);

        int n_square = numberOfMaxSizeSquare(max_square_side, rects[largest_rect_i]);
        System.out.println("Number of squares that can fit in Largest rectangle: " + n_square);
    }

    public static void printAllRectanglesArea(Rectangle[] rects) {
        System.out.println("--------------------------------------");
        System.out.println("Printing Rectangles areas.");

        for (int i = 0; i < rects.length; i++) {
            System.out.println("Area of rectangle " + (i + 1) + ": " + rects[i].getArea());
        }
    }

    public static int smallestRect(Rectangle[] rects) {
        System.out.println("--------------------------------------");
        System.out.println("Finding the smallest Rectangle.");

        int index = 0;
        double minArea = rects[0].getArea();
        for (int i = 1; i < rects.length; i++) {
            if (rects[i].getArea() < minArea) {
                index = i;
                minArea = rects[i].getArea();
            }
        }
        return index;
    }

    public static int largestRect(Rectangle[] rects) {
        int index = 0;
        double maxArea = rects[0].getArea();
        for (int i = 1; i < rects.length; i++) {
            if (rects[i].getArea() > maxArea) {
                index = i;
                maxArea = rects[i].getArea();
            }
        }
        return index;
    }

    public static double maxSqure(Rectangle largestRectangle) {
        return Math.min(largestRectangle.getWidth(), largestRectangle.getLength());
    }

    public static int numberOfMaxSizeSquare(double max_square_side, Rectangle largestRectangle) {
        return (int) (largestRectangle.getArea() / (max_square_side * max_square_side));
    }

    static Rectangle[] getRectangleArrayFromDataFile(String fileName) {
        // initialize list to store rectangles
        List<Rectangle> rectangles = new ArrayList<>();

        // open file and read data
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // split the line by space to get width and height
                String[] data = line.split(" ");
                int width = Integer.parseInt(data[0]);
                int height = Integer.parseInt(data[1]);

                // create rectangle object with the width and height
                rectangles.add(new Rectangle(width, height));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // convert list to array and return
        return rectangles.toArray(new Rectangle[0]);
    }
}