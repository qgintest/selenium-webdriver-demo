package corejava;

public class CountNumberOfOccurences {

	//Count number of occurences in a character
	public static void main(String[] args) {
		
		
		countOccurences("aandjkdsaddsa", 's');

	}

	private static void countOccurences(String word, char character) {
		
		int count = 0;
		
		for(int i = 0; i < word.length(); i++) {
			
			if(word.charAt(i) == character){
				count++;
			}
		}
		
		System.out.println(character + " occures " + count + " Times");
		
	}

}
