package corejava;

public class PrimeNumber {

	//Create a program to check if input number is prime number or not
	//Example prime numbers are 2, 3, 5, 7, 11, 13, 17, 19, 23, and 29
	//Prime Number is a whole number greater than 1. it is divisible by two numbers, 1 and itself.
	//4 is not prime because it has 3 divisors, 4/2/1
	
	
	public static void main(String[] args) {
		
		int num = 5;
	    boolean flag = false;
	    
	        //start with two       //only need to check half of it, if nonprime for up to half, if its not zero, the rest is not prime, matmathical fact
	    for (int i = 2; i <= num / 2; ++i) {
	      // condition for nonprime number
	      if (num % i == 0) {
	        flag = true;
	        break;
	      }
	    }

	    if (!flag)
	      System.out.println(num + " is a prime number.");
	    else
	      System.out.println(num + " is not a prime number.");
	  }
}
