
public class Febonotchi {

	static int calculateFebSeq(int number) {
		int i=number,calc=1;
		if(number == 0) {
			return 1;
		}
		while(i != 1) {
			calc = calc * i; 
			i--;
		}
		return calc;
	}
	
	public static void main(String[] args) {
		System.out.print(calculateFebSeq(5));
		
		
	}
	
}