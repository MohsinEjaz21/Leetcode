import java.util.ArrayList;

public class SumOfElems {


    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        ArrayList<Integer> rs = new ArrayList<>();
        int sum=0,i=0,j=0;
        
        while(i<n) {
        	j=i; sum=0;
        	while(j<n) {
        		sum=sum+arr[j];
        		if(sum==s) {
        			rs.add(++i);
        			rs.add(++j);
        			return rs;
        		}
        		j++;
        	}
        	i++;
        }
        rs.add(-1);
        return rs;
        
}
    
    public static void main(String[] args) {
    	 subarraySum(new int[]{1,2,3,7,5}, 5,12);
		}
    
}
