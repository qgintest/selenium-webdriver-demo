package corejava;

public class MultiplicationTable {

	//Print 5 Multplication table without using Multiply operator
	public static void main(String[] args) {
		

		System.out.println(multiply(5,10));
		
	}
	
	static int multiply(int i, int j) {
		
		//second index should be added x number of times based on first index, or vice versa.
		int sum = 0;
		
		for(int x = 0; x <i; x++ ) {
			sum+=j;
		}
		
//		for(int x = 0; x <j; x++ ) {
//			sum+=i;
//		}
		
		
//		int k = 0;
//		while(k<j) {
//			sum+=i;
//			k++;
//		}
		
//		while(k<i) {
//			sum+=j;
//			k++;
//		}
		
		return sum;
	}

}
