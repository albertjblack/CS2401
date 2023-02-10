package lab01ArrSrch;

public class Exercise1_lab1 {
  public static void main(String args[]){
    String name[] = {"a", "b", "c", "d"};
    int score[] = {89, 95, 60, 75};

    // task 1: print sum of all scores and average of scores
    // task 2: print the name of who got the highest core
    // task 3: print the names of who scored > average
    
    double tempSum = getSum(score, score.length);
    System.out.println("Sum: " + (int)tempSum);    

    double average = getAvg(score, score.length);
    System.out.println("Average: " + average); 

    System.out.println("Highest Score Name: " + name[getHighestScoreIdx(score, score.length)]); 
    
    printGreaterThanAverage(name, score, name.length, average);

  }

  static double getSum(int arr[], int size){
    double tempSum = 0;
    for (int i = 0; i < size; i++){
      tempSum+=arr[i];
    }
    return tempSum;
  }

  static double getAvg(int arr[], int size){
    double tempSum = getSum(arr,size);
    return tempSum/size;
  }

  static int getHighestScoreIdx(int arr[], int size){
    int currHighestIdx = 0;
    for (int i = 1; i < size; i++){
      if (arr[i] > arr[currHighestIdx]){
        currHighestIdx = i;
      }
    }
    return currHighestIdx;
  }

  static void printGreaterThanAverage(String _names[], int _scores[], int size, double avg){
    System.out.println("Greater than average...");
    for (int i = 0; i < size; i++){
      if (_scores[i]>avg){
        System.out.println(_names[i]);
      }
    }
  }

}
