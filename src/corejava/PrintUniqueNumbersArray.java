package corejava;

import java.util.ArrayList;
import java.util.List;

public class PrintUniqueNumbersArray {

	//Print unique numbers in array
	public static void main(String[] args) {
		
		
		int a[] = {4,5,5,4,6,6,9,4};
		
		List<Integer> numbers = new ArrayList<>();
		
		for(int i = 0; i < a.length; i++) {
			
			int k = 0;
			
			//This condition checks if value exists within array
			if(!numbers.contains(a[i])) {
				numbers.add(a[i]);
				k++;
				
				//this inner loop counts number of times a number is repeated
				//notice how it checks all numbers to the left of iterator
				for(int j=i+1; j<a.length; j++) {
					if(a[i] == a[j]) {
						k++;
					}
				}
				System.out.println(a[i] + " Repeated " + k + " times");	
			}	
		}
		
	}

}
