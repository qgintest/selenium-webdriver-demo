package corejava;

public class ReverseNumber {

	//Reverse number
	public static void main(String[] args) {
		
		//543
		//345
		
		//543%10 = 3
		
		//543/10 = 54
		
		//54%10=   4
		
		//54/10   = 5
		
		//5%10    = 5
		
		int n = 543;
		int reverse = 0;
		
		while(n!=0) {
			
			int digit = n % 10; 
//			      3   = 543 % 10
//		          4   = 54  % 10
//	              5   = 5   % 10
			
			reverse = digit + reverse * 10;    
//				3	  3	           0   *10
//			    34	  3	           3   *10	
//		        345	  5	           34  *10
			
			n = n / 10;
//			54 = 543/10
//			5 = 54/10
		}
		
		System.out.println(reverse);
	}

}
