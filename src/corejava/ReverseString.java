package corejava;


public class ReverseString {

	//Reverse the String without using Predefined Reverse methods or Palindrome Verification
	//Palindrome is a string that has the same meaning when reversed. s.g., madam
	public static void main(String[] args) {
		
		
		//Abraham
		//maharba
		
		
		//String s = "Abraham";
		String s = "madam";
		String r = "";
		
		for(int i = s.length()-1; i >=0; i--) {
			r = r+ s.charAt(i);
		}
		
		if(s.equals(r)) {
			System.out.println(s + " Is a Palindrome");
		}else {
			System.out.println(s + " Is NOT a Palindrome");
		}
	}

}
