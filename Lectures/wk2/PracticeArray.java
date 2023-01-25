// review - wk 2 

package Lectures.wk2;

class PracticeArray {
  public static void main(String[] args){
    
    int[] myArray;
    myArray  = new int[4];
    int[] myArray2 = {2,5,7,8};
    System.out.println(myArray);

    int myMax = getMax(myArray2);
    System.out.println(getMax(myArray2));

    
  }

  static void printArray(int[] arr){
    for (int i = 0; i<arr.length; i++){
      System.out.println(arr[i]);
    }
    System.out.println();
  }

  static int getMax(int[] arr){
    int _max = arr[0];
    for (int i = 1; i<arr.length;i++){
      if (arr[i] > _max){
        _max = arr[i];
      }
    }
    return _max;
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