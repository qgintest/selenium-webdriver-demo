package corejava;

public class PyramidPattern {

	//Print Pyramid Pattern in Java
	//This demonstrates understanding of outer and inner loops
	/*
	 * *
	 * **
	 * ***
	 * ****
	 * 
	 */
	public static void main(String[] args) {
		
		
		printPattern("*");

	}
	
	private static void printPattern(String pattern) {
		
		
		System.out.println(pattern);
				
		for(int row = 0; row < 5; row++) {			
			
			for(int column = 0; column <=row; column++) {
				System.out.print(pattern);
				System.out.print("\t");
			}
			System.out.println();
			
		}
		
	}

}
