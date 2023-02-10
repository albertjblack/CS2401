/* 
 * -----------------------------------------------------------------------------------------------------------------------------
 * Lab 03 - CS2401 - jaroblestos@miners.utep.edu
 * -----------------------------------------------------------------------------------------------------------------------------
 * - Input file "input.txt" -> dimensions of boxes -> (double,double,double)
 * -- Selling balls of different diameter
 * --- Find most suitable box from input file to pack the one ball
 * -----------------------------------------------------------------------------------------------------------------------------
 * INSTRUCTIONS TO COMPILE SUCCESSFULLY by RUNNING THROUGH THE TERMINAL and WITHOUT AN IDE
 * -----------------------------------------------------------------------------------------------------------------------------
 * 1. "RoblesTostado_JoseAlberto_Lab03.java", "Box.java", and "input.txt" must be in a folder (package) "Lab03"
 * 2. 'Compile' from ONE DIRECTORY above the package "Lab03" directory
 * $  javac ./Lab03/RoblesTostado_JoseAlberto_Lab03.java
 * 3. To 'run', i used the const PACKPATH="./Lab03/" because the main cannot be changed -> I used it as the value to add as prefix when opening the file
 * $  java Lab03/RoblesTostado_JoseAlberto_Lab03   
 * -----------------------------------------------------------------------------------------------------------------------------
 * X  If you are using an IDE It will depend how you do it based on your configuration. However, I'd advise you to follow the previous steps
 * -  In my case and configuration with VS Code, I need to work from a parent directory that holds my package folder, e.g. <root>/<package>/<files_used>
 * -  Which is why I created the PACKPATCH constant to add before my file so i can have, for this example. File("./Lab03/input.txt")
 * -  If you have any issues please send me an email 'jaroblestos@miners.utep.edu' or read java the documentation, remember that IDE are helpers and the terminal is the real deal
 * -  also keep in mind that the diameter expression does not generate a value between 0 and 20 like we were told, but between 2 and 22
 * -----------------------------------------------------------------------------------------------------------------------------
 */

package Lab03;

import java.io.File;
import java.util.Scanner;
import java.lang.Math;

public class RoblesTostado_JoseAlberto_Lab03 {
    public static final String PACKPATH = "./Lab03/";

    public static void main(String[] args) {

        Box[] boxes;

        boxes = getBoxArrayFromDataFile("input.txt");

        printAllBoxes(boxes);

        int range = 20;
        int diameter = (int) (Math.random() * range) + 2;
        // diameter = 13;

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

    public static int helperGetEntryCountFromFile(String fileName) {
        File myFile;
        Scanner scn;
        int count = 0;
        try {
            myFile = new File(PACKPATH + fileName);
            scn = new Scanner(myFile);
            while (scn.hasNextLine()) {
                count++;
                if (scn.hasNextLine()) {
                    scn.nextLine();
                }
            }
            scn.close();
            return count;
        } catch (Exception e) {
            System.out.println(
                    "There has been an error <" + e
                            + "> at <helperGetEntryCountFromFile>. Please check that your 'input.txt' file is in the same folder as the java file.");
            return count;
        }
    }

    public static Box[] getBoxArrayFromDataFile(String fileName) {
        File myFile;
        int entryCount = helperGetEntryCountFromFile(fileName);
        Box[] boxes = new Box[entryCount];
        Scanner scn;

        try {
            myFile = new File(PACKPATH + fileName);
            scn = new Scanner(myFile);
            for (int i = 0; i < entryCount; i++) {
                boxes[i] = new Box(scn.nextDouble(), scn.nextDouble(), scn.nextDouble());

                if (scn.hasNextLine()) {
                    scn.nextLine();
                }
            }

            scn.close();
            return boxes;

        } catch (Exception e) {
            System.out.println(
                    "There has been an error <" + e
                            + "> at <getBoxArrayFromDataFile>. Please check that your 'input.txt' file is in the same folder as the java file.");
            return null;
        }

    }

    public static void printAllBoxes(Box[] theBoxes) {
        System.out.println();
        System.out.println("--------------------------------------\n");
        System.out.println("- Printing box dimensions.");
        for (int i = 0; i < theBoxes.length; i++) {
            System.out.println(String.format(
                    "Index: <%d>  Width: <%.2f>  Height: <%.2f>  Length: <%.2f>  Volume: <%.2f>", i,
                    theBoxes[i].getWidth(), theBoxes[i].getHeight(), theBoxes[i].getLength(), theBoxes[i].getVolume()));
        }
    }

    public static void canContain(Box[] theBoxes, int diameter) {
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("- Checking for boxes that can hold the ball.");
        System.out.println("The diameter of the ball: " + diameter);
        int counter = 0;
        for (int i = 0; i < theBoxes.length; i++) {
            if (helperGetSpheresPerBox(theBoxes[i], diameter) > 0) {
                counter++;
                System.out.println(String.format(
                        "Index: <%d>  Width: <%.2f>  Height: <%.2f>  Length: <%.2f>  Volume: <%.2f>", i,
                        theBoxes[i].getWidth(), theBoxes[i].getHeight(), theBoxes[i].getLength(),
                        theBoxes[i].getVolume()));
            }
        }
        System.out.println("The number of boxes that can hold the ball is: " + counter);

    }

    public static int helperGetSpheresPerBox(Box _box, double _diameter) {
        int spheresX = (int) (_box.getWidth() / _diameter);
        int spheresY = (int) (_box.getHeight() / _diameter);
        int spheresZ = (int) (_box.getLength() / _diameter);
        return spheresX * spheresY * spheresZ;
    }

    public static int helperGetSmallerIdx(Box[] theBoxes, double _diameter) {
        int smallest_idx = 0;
        for (int i = 1; i < theBoxes.length; i++) {
            if (theBoxes[i].getVolume() < theBoxes[smallest_idx].getVolume()
                    && helperGetSpheresPerBox(theBoxes[i], _diameter) > 0) {
                smallest_idx = i;
            }
        }
        return (helperGetSpheresPerBox(theBoxes[smallest_idx], _diameter) > 0) ? smallest_idx : -1;

    }

    public static int helperGetLargestIdx(Box[] theBoxes) {
        int largest_idx = 0;
        for (int i = 1; i < theBoxes.length; i++) {
            if (theBoxes[i].getVolume() > theBoxes[largest_idx].getVolume()) {
                largest_idx = i;
            }
        }
        return largest_idx;
    }

    public static void smallestBox(Box[] theBoxes, int diameter) {
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("- Finding the smallest box to ship the ball.");
        System.out.println("Diameter of the ball to ship: " + diameter);

        int smallest_idx = helperGetSmallerIdx(theBoxes, diameter);
        if (smallest_idx > -1) {
            System.out.println("Information of the smallest box");
            System.out.println(String.format(
                    "Index: <%d>  Width: <%.2f>  Height: <%.2f>  Length: <%.2f>  Volume: <%.2f>", smallest_idx,
                    theBoxes[smallest_idx].getWidth(), theBoxes[smallest_idx].getHeight(),
                    theBoxes[smallest_idx].getLength(),
                    theBoxes[smallest_idx].getVolume()));
        } else {
            System.out.println("Found no such box to fit the ball(s) in.");
        }
    }

    public static int largestBox(Box[] theBoxes, int diameter) {
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("- Finding the largest box to ship the ball.");
        int largest_idx = helperGetLargestIdx(theBoxes);
        if (helperGetSpheresPerBox(theBoxes[largest_idx], diameter) > 0) {
            System.out.println(String.format(
                    "Largest box that can hold the ball is in index <%d> with volume: <%.2f>", largest_idx,
                    theBoxes[largest_idx].getVolume()));
        } else {
            System.out.println("Found no such box to fit the ball(s) in.");
        }
        return largest_idx;
    }

    public static int shipHowMany(int diameter, Box largestBox) {
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("- Finding how many ball(s) can be shipped in the largest box.");
        return helperGetSpheresPerBox(largestBox, diameter);
    }

}
