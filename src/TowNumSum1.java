import java.util.*;

public class TowNumSum1 {
  public static int[] twoNumberSum(int[] array, int targetSum) {
    // Write your code here.
    int i=0;
    int j=0;
    int sum=0;
    int size=array.length;
    
    while(i<size-1){
      sum=0;
      j=i+1;
      while(j<size){
        sum = array[i]+array[j];
        if(sum==targetSum){
          return new int[] {array[i],array[j]};
        }
        j++;
      }
      i++;
    }
    
    return new int[] {array[i],array[j]};
  }
  
 public static void main(String[] args) {
	 twoNumberSum(new int[] {-21, 301, 12, 4, 65, 56, 210, 356, 9, -47},164);
}
}
