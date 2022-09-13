import java.util.HashMap;

public class Febonotchi {
	static HashMap<Integer, Integer> memoFactorial = new HashMap<>();

	static int fact(int number) {
		int i=number,calc=1;
		if(number == 0) {
			return 1;
		}
		while(i != 1) {
			calc = calc * i; 
			memoFactorial.put(i,calc);
			i--;
		}
		return calc;
	}
	
	
	static int fib(int n) {
	 if(n==2) {
		 return 1;
	 }
	 else if(n==1) {
		 return 0;
	 }
	
	 return fib(n-1)+fib(n-2);		 		 

	}
	
	public static void main(String[] args) {
		System.out.print(fib(10));
		
		
	}
	
}