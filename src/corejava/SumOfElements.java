package corejava;


//Create a method which accepts Array and returns sum of all elements in array
public class SumOfElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {1, 2, 3, 4, 5}; 
		
		
		int sum = sumArray(a);
		System.out.println(sum);
	}

	private static int sumArray(int[] a) {
		
		int sum = 0;
		//extract every value of array and sum each value with other
		
		//Solution 1
//		for(int i=0; i < a.length; i++) {
//			
//			sum = sum + a[i];
//		}
		
		//Enhanced solution
		for(int number: a) {
			sum+=number;
			//sum = sum + number;
		}
		
		return sum;
	}
}
