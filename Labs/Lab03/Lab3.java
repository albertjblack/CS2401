package Lab03;

import java.lang.Math;

class Lab3 {
    public static void main(String[] args) {

        Box[] boxes;

        boxes = getBoxArrayFromDataFile("input.txt");

        printAllBoxes(boxes);

        int range = 20;
        int diameter = (int) (Math.random() * range) + 2;

        canContain(boxes, diameter);

        smallestBox(boxes, diameter);

        int l_index = largestBox(boxes, diameter);
        if (l_index >= 0) {
            int count = shipHowMany(diameter, boxes[l_index]);
            System.out.println(count + " ball(s) can be shipped in the largest box.");
            System.out.println("--------------------------------------\n");
        } else {
            System.out.println("Found no such box");
            System.out.println("--------------------------------------\n");
        }

    }

    /**
     * Complete this method to print the Box
     * objects in the array parameter theBoxes
     * 
     * @param theBoxes is the array of Box objects
     */

    public static void printAllBoxes(Box[] theBoxes) {
        System.out.println("--------------------------------------");
        System.out.println("Printing box dimensions.");

        // You are not allowed to change the header.
        // Change the body of this method.
        System.out.println("I have not yet implemented the printBoxes method.");

    }

    /**
     * Change the body of this method to print the box
     * objects in the array parameter that can hold/store
     * the ball whose diameter is given in the parameter.
     * 
     * @param theBoxes is the array of Box objects
     * @param diameter of the ball
     */

    public static void canContain(Box[] theBoxes, int diameter) {
        System.out.println("--------------------------------------");
        System.out.println("Checking for boxes that can hold the ball.");
        System.out.println("The diameter of the ball: " + diameter);

        // You are not allowed to change the header.
        // Change the body of this method.

        System.out.println("I have not yet implemented the canContain method.");

    }

    /**
     * Change the body of this method to print the information
     * of the smallest Box object that can hold the ball of
     * the given diameter
     * 
     * @param theBoxes is the array of Box objects
     * @param diameter of the ball
     */

    public static void smallestBox(Box[] theBoxes, int diameter) {
        System.out.println("--------------------------------------");
        System.out.println("Finding the smallest box to ship the ball.");

        // You are not allowed to change the header.
        // Change the body of this method.

        System.out.println("I have not yet implemented the smallestBox method.");
    }

    /**
     * Change the body of this method to (a) print the information
     * of the largest Box object that can hold the ball of
     * the given diameter, and (b) return the index of that object.
     * 
     * @param theBoxes is the array of Box objects
     * @param diameter of the ball
     * @return index of the largest box, -1 if no such box is found.
     */

    public static int largestBox(Box[] theBoxes, int diameter) {
        // You are not allowed to change the header.
        // Change the body of this method.

        System.out.println("I have not yet implemented the largestBox method.");
        return 0;
    }

    /**
     * Change the body of this method to return â€œthe number of
     * ballsâ€ with the given diameter that can be shipped in the largest box
     * 
     * @param diameter   of the ball to be shipped
     * @param largestBox is the box Object with largest volume
     * @return the number of ball(s) that can be shipped in the
     *         largest Box object
     */

    public static int shipHowMany(int diameter, Box largestBox) {
        // You are not allowed to change the header.
        // Change the body of this method.

        System.out.println("I have not yet implemented the shipHowMany method.");
        return 0;
    }

    /**
     * Change the body of this method to return an array
     * of Box objects, created after reading the file.
     * 
     * @param filename
     * @return the array of Box objects created from the fileName file
     */

    static Box[] getBoxArrayFromDataFile(String fileName) {
        // You are not allowed to change the header.
        // Change the body of this method.

        System.out.println("I have not yet implemented the method to \nconstruct the array from the input file.");

        return null;
    }
}