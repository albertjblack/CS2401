/* 
 * Pass by value vs reference (Java)
 */

package Lectures.wk2;
class Day3{

  public static void main(String[] args){
    int i = 10;
    System.out.println("Value of i before the method: " + i);
    myMethodInt(i);
    System.out.println("Value of i after the method: " + i);

    int[] myArray = {2,5,6,7};
    System.out.println("Value of myArray[0] before method: " + i);
    myMethodArray(myArray);
    System.out.println("Value of myArray[0] after method: " + myArray[0]);

  }

  public static void myMethodInt(int i){
    i+=3;
    System.out.println("Value of variable (i) withing method: " + i);
  }

  public static void myMethodArray(int arr[]){
    arr[0]+=3;
    System.out.println("Value of variable (arr) withing method: " + arr[0]);
  }

}