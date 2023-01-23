// review - wk 2 

package Lectures.wk2;

class PracticeArray {
  public static void main(String[] args){
    int[] myArray;
    myArray  = new int[4];
    int[] myArray2 = {2,5,7,8};
    System.out.println(myArray);
  }

  static void printArray(int[] arr){
    for (int i = 0; i<arr.length; i++){
      System.out.println(arr[i]);
    }
    System.out.println();
  }

};