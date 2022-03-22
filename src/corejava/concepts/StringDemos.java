package corejava.concepts;

public class StringDemos {

	public static void main(String[] args) {
		
		String a = "hello"; //String literal
		
		String b = "hello"; //Another object will not be created because in memory, it will check 
		//if one is created. if it exists, referene will point to original object
		
		a.concat("World");
		System.out.println(a); //only hello will print because they are immutable, cannot be altered
		
		String c = a.concat("World"); //This will print hello world
		//so for above example, how many memory objects are created? Answer: 1
		
		String s = new String("hello"); //String class creates new object in memory every time
		String t = new String("hello");
		
		
		//StringBuffer and StringBuilder are mutuable (changeable) 
		StringBuffer ab = new StringBuffer("hello");
		
		ab.append(" World");
		
		System.out.println(ab); //Will print hello world

		ab.insert(2, "She");
		
		System.out.println(ab);
		
		ab.replace(0, 4, "new");
		
		System.out.println(ab);
		
		ab.reverse(); //can reverse string
		
		//StringBuilder - same functionality, but not thread-safe. so meant for sequential runs and is faster
		//StringBuffer - thread-safe/ can use for parallel runs. next thread will only execute once previous thread 
	
		//Equals (Content) vs == (checks reference) 
		
		System.out.println(a.equals(b)); //True
		System.out.println(a==b); //True
		
		System.out.println(a.equals(s)); //True
		
		System.out.println(a==s); //False //References are diff
		System.out.println(s==t); //False //References are diff
		
		System.out.println(a.equals(t)); //True Content is same
		
	}

}
