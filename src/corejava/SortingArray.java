package corejava;

import java.util.ArrayList;
import java.util.List;

public class SortingArray {

	//Sort the array asc and desc order
	public static void main(String[] args) {
		
		
		//just compare first index with all other values. need outer and inner loop
		
		
		int[] a = {10,34,8,13,17,5}; 
		int temp;
		
		for(int i = 0; i < a.length; i++) {
			
			for(int j=i+1; j< a.length; j++) {
				
				//asc
//				if(a[i] > a[j]) {
//					//swap
//					temp=a[i];
//					a[i] = a[j];
//					a[j] = temp;
//				}
				
				//desc
//				if(a[i] < a[j]) {
//					//swap
//					//similar to fruit basket scneario, 3 baskets. one apple, one orange, one empty. to swap, remove fruit from one basket and place into empty
//					temp=a[i];
//					a[i] = a[j];
//					a[j] = temp;
//				}
				
				//desc, without temp variable
				if(a[i] < a[j]) {
					//swap					
					a[i] = a[i] + a[j];
					a[j] =a[i] - a[j];
					a[i] = a[i] - a[j];
				}
			}
			
		}
		
		for(int b: a) {
			System.out.println(b);
		}
		
		
		//look at example below for swapping without thrid temp var
//		int one = 1;
//		int two = 2;
//		
//		one = one + two; //one = 3
//		two = one - two; //3 - 2 = 1
//		one = one - two; //3 - 1 = 2
	}

	
	
	
	
	
}
