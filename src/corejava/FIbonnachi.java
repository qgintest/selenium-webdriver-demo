package corejava;

public class FIbonnachi {

	//Print fibonnachi series of up to 7 digits
	//1, 2, 3, 5, 8, 13, 21, 34
	public static void main(String[] args) {
		
			printFibN(6);
		
	}
	
	private static void printFibN(int digits) {
		int a = 0;
		int b = 1;
		int sum = 0;
		
		//System.out.print(firstDigit + "\t");
		
		for(int i = 0; i<digits; i++) {
			
			sum = a + b;
			System.out.print(sum + "\t");
			a=b;
			b = sum;
		}
		
	}

}
