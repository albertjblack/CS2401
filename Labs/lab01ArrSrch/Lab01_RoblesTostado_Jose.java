/* 
 * -----------------------------------------------------------------------------------------------------------------------------
 * Lab 01 - CS2401 - jaroblestos@miners.utep.edu
 * -----------------------------------------------------------------------------------------------------------------------------
 * Input file "input.txt" -> 12 lines (months[1-12]) -> 3 cols (\t) sep. | month | mph | avg. rain | -> (int,double,double)
 * -----------------------------------------------------------------------------------------------------------------------------
 * 1. Read file
 * 1.2. Store data in an array
 * 1.3. Display information
 * -----------------------------------------------------------------------------------------------------------------------------
 * 2. Display information (detailed)
 * a) avg windspeed for that year
 * b) how many months had more than avg windspeed? their indices (0+1), and based on their index their name -> (5, May)
 * c) avg rainfall for that year
 * d) how many months had more than avg rainfall? their indices (0+1), and based on their index their name -> (5, May)
 * ! use try-catch for reading
 * -----------------------------------------------------------------------------------------------------------------------------
 * 3. Test cases
 * 1) correct
 * 2) exception (file location or incorrect format)
 * -----------------------------------------------------------------------------------------------------------------------------
 * My Assumptions
 * - 12 lines per file
 * -- each line represents a month of a yr
 * ---- each line format: mth\tmph\train\n
 * ----- each month has one and only one entry
 * -----------------------------------------------------------------------------------------------------------------------------
 */

package lab01ArrSrch;

import java.io.File;
import java.util.Scanner;

public class Lab01_RoblesTostado_Jose {

  public static void main(String args[]) {
    final int QTY = 12;
    final String FILELOC = "./input.txt";
    String monthNames[] = new String[] { "January", "February", "March", "April", "May", "June", "July", "August",
        "September", "October", "November", "December" };
    double windSpeeds[] = new double[QTY]; // mph
    double rainFalls[] = new double[QTY]; // inches

    try {

      File inputFile = new File(FILELOC);
      Scanner scn = new Scanner(inputFile);

      while (scn.hasNextLine()) {
        int mth = scn.nextInt();
        windSpeeds[mth - 1] = scn.nextDouble();
        rainFalls[mth - 1] = scn.nextDouble();

        // System.out.println("m:"+mth+", s:"+windSpeeds[mth-1]+",
        // r:"+rainFalls[mth-1]);

        if (scn.hasNextLine()) {
          scn.nextLine();
        }
      }
      scn.close();
      printEntries(QTY, monthNames, windSpeeds, rainFalls);

    } catch (Exception e) {
      System.out.println("Error: " + e + ". Please try again after fixing this.");
    }
    System.out.println();
  }

  public static void printEntries(int size, String arrMthNames[], double arrSpeeds[], double arrRains[]) {
    double avgWindspeed = getAvg(size, arrSpeeds);
    System.out.println();
    System.out.println("Avg. windspeed (mph): " + String.format("%.2f", avgWindspeed));
    System.out.println("Windspeeds above average:");
    int count = 0;
    for (int i = 0; i < size; i++) {
      if (arrSpeeds[i] > avgWindspeed) {
        count++;
        System.out.println("(" + (i + 1) + ", " + arrMthNames[i] + ")");
      }
    }
    System.out.println(count + " months with above average windspeed.");
    System.out.println();

    double avgRainfall = getAvg(size, arrRains);
    System.out.println("Avg. rainfall (in): " + String.format("%.2f", avgRainfall));
    System.out.println("Rainfalls above average:");
    count = 0;
    for (int i = 0; i < size; i++) {
      if (arrRains[i] > avgRainfall) {
        count++;
        System.out.println("(" + (i + 1) + ", " + arrMthNames[i] + ")");
      }
    }
    System.out.println(count + " months with above average rainfall.");

  }

  public static double getAvg(int size, double arr[]) {
    double currSum = 0.0;
    for (double x : arr) {
      currSum += x;
    }
    return currSum / size;
  }

}
