package corejava;

public class MinMaxMultiDim {

	//Print Min number and Max number in Multi Dimensional Array 3 * 3 Matrix
	public static void main(String[] args) {
		
		/*
		 * 2	4	5
		 * 3	4	7
		 * 1	2	9
		 */

		int multi [][] = {{2, 4, 5}, {3, 10, 7}, {-5, 2, 9}};

		int min = 0;
		int max = 0;
		boolean firstNum = true;
		
		for(int[] c: multi) {
			
			for(int r: c) {
				
				if(firstNum == true) {
					min = r;
					max = r;
					firstNum = false;
				}else {
					if(r < min) {
						min = r;	
					};
					
					if(r > max) {
						max = r;
					}
				}
			}
		}
		
		System.out.println("Minimum Number is: " + min);
		System.out.println("Maximum Number is: " + max);
		
	}

}
