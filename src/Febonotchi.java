import java.util.Arrays;
import java.util.HashMap;

public class Febonotchi {
	static HashMap<Integer, Integer> memoFib = new HashMap<>();

	static int fact(int number) {
		int i = number, calc = 1;
		if (number == 0) {
			return 1;
		}
		while (i != 1) {
			calc = calc * i;
			i--;
		}
		return calc;
	}

	static int fib(int n) {
		if (n == 2) {
			return 1;
		} else if (n == 1) {
			return 0;
		}else {
			return fib(n - 1) + fib(n - 2);
		}
	}
	
	static int[] iterativeFeb(int n) {
		int[] feb = new int[n-1];
		int count = 2;		
		if(n==0) {
			return new int[] {0};
		}
		if(n==1) {
			return new int[] {0,1};
		}
		feb[0]=0;
		feb[1]=1;
		while(count < n-1) {
			feb[count] = feb[count-1]+ feb[count-2];
			count++;
		}
		return feb;
	}
	

	static int fibMemo(int n) {
		if (n == 2) {
			return 1;
		} else if (n == 1) {
			return 0;
		}

		if (!memoFib.containsKey(n)) {
			memoFib.put(n, fib(n - 1) + fib(n - 2));			
		}

		return memoFib.get(n);
	}

	

	public static void main(String[] args) {
    System.out.println("fib :: "+Arrays.toString(iterativeFeb(9)));
	}

}