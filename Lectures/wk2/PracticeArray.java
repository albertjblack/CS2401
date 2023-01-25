// review - wk 2 

package Lectures.wk2;
class PracticeArray {
  public static void main(String[] args){

    /* 1D Array */
    
    int[] myArray;
    myArray  = new int[4];
    int[] myArray2 = {2,5,7,8};
    System.out.println(myArray);
    System.out.println();

    int myMax = getMax(myArray2);
    System.out.println(getMax(myArray2));
    System.out.println();

    
    /* 2D Array */

    int TwoDArray[][] = {
      {10,5,3,20},
      {20,11,30,50,100,200},
      {25, 30},
    };

    print2DArray(TwoDArray);
    System.out.println();


  }

  public static void printArray(int[] arr){
    for (int i = 0; i<arr.length; i++){
      System.out.println(arr[i]);
    }
    System.out.println();
  }

  public static int getMax(int[] arr){
    if ( arr==null || arr.length==0 ){
      return -1;
    }
    int _max = arr[0];
    for (int i = 1; i<arr.length;i++){
      if (arr[i] > _max){
        _max = arr[i];
      }
    }
    return _max;
  }

  public static void print2DArray(int arr[][]){
    for(int i = 0; i<arr.length; i++){
      for(int j=0; j<arr[i].length; j++){
        System.out.print(arr[i][j]+", ");
      }
      System.out.println();
    }
  }

};

/* 

  shifting 
 
  int[] myList = {1, 2, 3, 4, 5, 6};

  for (int i = myList.length - 2; i >= 0; i--) {
    myList[i + 1] = myList[i];
  }

  for (int e: myList) 
    System.out.print(e + " ");

 */