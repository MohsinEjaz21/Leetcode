import java.util.HashMap;

public class BracketMatch {
	
	public static void main(String[] args) {
		compute("[{{{}}}]");
		
	}

	static void compute(String s1 ) {
		boolean isBracketsMatched=true;
		HashMap<Character,Character> bracketPair = new HashMap<>();
		bracketPair.put('{', '}');
		bracketPair.put('[', ']');
		bracketPair.put('(', ')');
		
		

		
		for(int i=0,j=s1.length()-1; i<s1.length() && j > i ;i++,j--) {
			char brack1 =bracketPair.get(s1.charAt(i));
			char brack2 =s1.charAt(j);

			System.out.println("brack1,i"+brack1 +','+i);
			System.out.println("brack2,j"+brack2+','+j);


			if(brack1 != brack2) {
				isBracketsMatched = false;
				break;
			}
		}
	 System.out.println(isBracketsMatched);
	}
	
}
