package corejava;

public class MaxDifference {

	//Max Difference between any adjacent index in array
	//so in below array, 4-1 = 3, 8-4 = 4
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {1,4,8,15,17}; //3, 4, 7, 2, so max here is 7
		//int[] a = {1,15,8,15,17};
		
		//given size of array, find diff between each adjoining arrray
		//print out the largest diff
		int Max = findMax(a);
		
		System.out.println(Max);
		
	}

	private static int findMax(int[] a) {
		
		
		int diff = 0;
		
		for(int i = 0; i<a.length - 1; i++) {
			
			if(a[i+1] - a[i] > diff){
				diff = (a[i+1] - a[i]);
			}
		}
		
		
		//return largest difference
		return diff;
	}

}
