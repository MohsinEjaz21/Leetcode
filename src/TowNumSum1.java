import java.util.*;

public class TowNumSum1 {
  public static int[] twoNumberSum(int[] array, int targetSum) {
    // Write your code here.
    int sum=0;
    int i=0;
    int j=0; 
    int size = array.length;
    System.out.println("size :: "+size);

    while(i< size-1){    	
      if(sum == targetSum){
        return new int[] {array[i],array[j]};
      }else{
        if(j==size-1) {
        	j=i+1;
        	i++;
        }else {
        	j++;
        }
        System.out.println("i :: "+i);
        System.out.println("j :: "+j);
        if(i != j) {
        	sum =array[i]+array[j];
        }
      }
      
    }
    return new int[] {};
  }
  
 public static void main(String[] args) {
	 twoNumberSum(new int[] {2,8},10);
}
}


