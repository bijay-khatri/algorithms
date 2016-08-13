/*You have written an anonymous love letter and you don't want your handwriting 
to be recognized. Since you don't have a printer within reach, 
you are trying to write this letter by copying and pasting characters from a newspaper.

Given a string L representing the letter and a string N representing the newspaper, 
return true if the L can be written entirely from N and false otherwise.
The letter includes only ascii characters.

@author Bijay Khatri
@since August 13 2016
@version 1.0
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class AnonymousLetter{
	
	private void test(String testName, String newspaper, String letter, boolean expected){
		System.out.print(testName + " started...");

		if(canLetterBeWritten2(newspaper, letter) == expected){
			print("pass");
		}
		else print("FAIL");
	}


	private static void print(Object o){
		System.out.println(o);
	}

	private void test1(){
		test("Test1", "","letter", false);
	}

	private void test2(){
		test("Test2","","",true);
	}

	private void test3(){
		test("Test3","newspaper","",true);
	}

	private void test4(){
		test("Test4","I am the world", "math or die", true);
	}

	private void test5(){
		test("Test5","I am the world", "math ork ai", false);
	}
	public static void main(String [] args){
		AnonymousLetter obj = new AnonymousLetter();
		obj.test1();
		obj.test2();
		obj.test3();
		obj.test4();
		obj.test5();
	}

	private boolean canLetterBeWritten(String newspaper, String letter){
		
		if(newspaper == null || letter == null) throw new IllegalArgumentException("Invalid input");
		if(newspaper.isEmpty() && letter.isEmpty()) return true;
		if(newspaper.isEmpty() && !letter.isEmpty()) return false;
		if(!newspaper.isEmpty() && letter.isEmpty()) return true;
		if(letter.length() > newspaper.length()) return false;

		newspaper = newspaper.toLowerCase();
		letter = letter.toLowerCase();

		//Assuming characters are in ASCII with 256 unique characters
		
		Map<Character,Integer> bucket = new HashMap<>();

		//Go through all the newspaper and fill in the map
		for(int i = 0; i < newspaper.length(); i++){
			char temp = newspaper.charAt(i);
			if(bucket.get(temp) !=null){
				bucket.put(temp, bucket.get(temp) + 1);
			}
			else
				bucket.put(temp, 1);
		}

		for(int i = 0; i < letter.length(); i++){
			char temp = letter.charAt(i);
			if(bucket.get(temp) == null) return false;
		}

		return true; 
		// O(N + L)
	}

	// Trying to improve a bit by first creating map of characters from letter
	// if every character from the letter is also in newspaper (which could be found early)
	// decrement the count by 1 and check if the total of values is zero
	// zero means all characters from letter is also in newspaper

	private boolean canLetterBeWritten2(String newspaper, String letter){
		if(newspaper == null || letter == null) throw new IllegalArgumentException("Invalid input");
		if(newspaper.isEmpty() && letter.isEmpty()) return true;
		if(newspaper.isEmpty() && !letter.isEmpty()) return false;
		if(!newspaper.isEmpty() && letter.isEmpty()) return true;
		if(letter.length() > newspaper.length()) return false;

		letter = letter.toLowerCase();
		newspaper = newspaper.toLowerCase();

		Map<Character,Integer> bucket = new HashMap<>();
		//O(L)
		for(char c: letter.toCharArray()){
			if(bucket.get(c) == null)
				bucket.put(c, 1);
			else 
				bucket.put(c, bucket.get(c) + 1);
		}

		for(char c: newspaper.toCharArray()){
			if(bucket.get(c) !=null)
				bucket.put(c, bucket.get(c) - 1);

			if(bucketZero(bucket.values())) return true;
		}
		return false;
	}

	private boolean bucketZero(Collection<Integer> nums){
		int sum = 0;
		for(Integer i: nums){
			sum +=i;
		}

		return sum == 0;
	}
}