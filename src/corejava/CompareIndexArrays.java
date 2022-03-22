package corejava;

import java.util.ArrayList;
import java.util.List;

public class CompareIndexArrays {

	
	//Compare same indexes of 2 different arrays and create another array for matching values
	//This will differentiate between Arrays and ArrayList
	public static void main(String[] args) {
		

		int[] a = {1,3,8,13,17}; 
		int[] b = {1,4,8,15,17};
		
		List<Integer> match = new ArrayList<>();
		
		for(int i = 0; i < a.length; i++) {
			
			if (a[i] == b[i]) {
				match.add(a[i]);
			}
			
		}
		
		
		for(int c: match) {
			System.out.println(c);
		}
		
		
		//System.out.println("ArrayList of Matching values: " + match);	
	}

}
