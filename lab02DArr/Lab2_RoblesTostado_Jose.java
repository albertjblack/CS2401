/* 
* -----------------------------------------------------------------------------------------------------------------------------
* Lab 02 - CS2401 - jaroblestos@miners.utep.edu
* -----------------------------------------------------------------------------------------------------------------------------
* Input file "input_2.txt" -> 'n' rows (farms) by 12 columns of integer values 
* -----------------------------------------------------------------------------------------------------------------------------
* 1. Read file
* ---- comma separated values
* 1.2. Store data in an array
* 1.3. Display information
* -----------------------------------------------------------------------------------------------------------------------------
* 2. Methods
* -- farm_avg : computes the average production of each farm
* -- month_avg : computes the average production for each month
* -- top_farms : top 3 farms with the highest production : display idx of farms (0-n) and total of the year for each farm
* -- top_months : top 3 months with the highest production : display idx of months (0-11) and total of that month for all
* -----------------------------------------------------------------------------------------------------------------------------
* 
*/

// I DECIDED TO DO THE FILE EXCEPTION NOT FOUND IS HANDLING IN A PER METHOD BASIS

import java.io.File;
import java.util.Scanner;

public class Lab2_RoblesTostado_Jose {
    public static String FILELOC = "./input_2.txt";

    public static void main(String args[]) {
        final int COLNUM = 12;
        try {
            final int ROWNUM = get_num_rows();
            if (ROWNUM == -1) {
                return;
            }

            int farmsArray[][] = new int[ROWNUM][COLNUM];
            set_farms_array(farmsArray);

            farm_avg(farmsArray);
            System.out.println();

            month_avg(farmsArray);
            System.out.println();

            top_farms(farmsArray);
            System.out.println();

            top_months(farmsArray);
            System.out.println();

        } catch (Exception e) {
            System.out.println("Error from main: " + e + ". Please try again after fixing this.");
            return;
        }

        System.out.println();

    }

    public static int get_num_rows() {
        int numRows = 0;
        try {
            File inputFile = new File(FILELOC);
            Scanner scn = new Scanner(inputFile);
            while (scn.hasNextLine()) {
                numRows++;
                if (scn.hasNextLine()) {
                    scn.nextLine();
                }
            }
            scn.close();
        } catch (Exception e) {
            System.out.println("Error from get_num_rows: " + e + ". Please try again after fixing this.");
            return -1;
        }

        return numRows;
    }

    public static void set_farms_array(int farmsArray[][]) {
        try {
            File inputFile = new File(FILELOC);
            Scanner scn = new Scanner(inputFile);
            for (int i = 0; i < farmsArray.length; i++) {
                String line = scn.nextLine();
                String tmp[] = line.split(",", 0);
                for (int j = 0; j < farmsArray[0].length; j++) {
                    farmsArray[i][j] = Integer.parseInt(tmp[j].trim());
                }
            }
            scn.close();
        } catch (Exception e) {
            System.out.println("Error from set_num_rows: " + e + ". Please try again after fixing this.");
            return;
        }
    }

    public static void farm_avg(int[][] data) {
        for (int i = 0; i < data.length; i++) {
            double _sum = 0;
            for (int j = 0; j < data[0].length; j++) {
                _sum += data[i][j];
            }
            System.out.println(
                    "Sum for farm " + i + " is: " + String.format("%.2f", _sum));
            System.out.println(
                    "Average production for farm " + i + " is: " + String.format("%.2f", (_sum / (data[0].length))));
        }

    }

    public static void month_avg(int[][] data) {

        for (int j = 0; j < data[0].length; j++) {
            double _sum = 0;
            for (int i = 0; i < data.length; i++) {
                _sum += data[i][j];
            }

            System.out.println(
                    "Average production for month " + j + " is: " + String.format("%.2f", (_sum / (data.length))));
        }

    }

    public static void top_farms(int[][] data) {

        int max1 = -1;
        int max1idx = 0;

        int max2 = -2;
        int max2idx = 0;

        int max3 = -3;
        int max3idx = 0;

        for (int i = 0; i < data.length; i++) {
            int _sum = 0;
            for (int j = 0; j < data[0].length; j++) {
                _sum += data[i][j];
            }

            if (_sum > max1) {
                max3 = max2;
                max3idx = max2idx;

                max2 = max1;
                max2idx = max1idx;

                max1 = _sum;
                max1idx = i;
            } else if (_sum > max2) {
                max3 = max2;
                max3idx = max2idx;

                max2 = _sum;
                max2idx = i;
            } else if (_sum > max3) {
                max3 = _sum;
                max3idx = i;
            }

        }

        System.out.println("Farm with the first highest production: " + max1idx + " with production: " + max1);
        System.out.println("Farm with the second highest production: " + max2idx + " with production: " + max2);
        System.out.println("Farm with the third highest production: " + max3idx + " with production: " + max3);

    }

    public static void top_months(int[][] data) {

        int max1 = -1;
        int max1idx = 0;

        int max2 = -2;
        int max2idx = 0;

        int max3 = -3;
        int max3idx = 0;

        for (int j = 0; j < data[0].length; j++) {
            int _sum = 0;
            for (int i = 0; i < data.length; i++) {
                _sum += data[i][j];
            }

            if (_sum > max1) {
                max3 = max2;
                max3idx = max2idx;

                max2 = max1;
                max2idx = max1idx;

                max1 = _sum;
                max1idx = j;
            } else if (_sum > max2) {
                max3 = max2;
                max3idx = max2idx;

                max2 = _sum;
                max2idx = j;
            } else if (_sum > max3) {
                max3 = _sum;
                max3idx = j;
            }
        }
        System.out.println("Month with the first highest production: " + max1idx + " with production: " + max1);
        System.out.println("Month with the second highest production: " + max2idx + " with production: " + max2);
        System.out.println("Month with the third highest production: " + max3idx + " with production: " + max3);
    }

}