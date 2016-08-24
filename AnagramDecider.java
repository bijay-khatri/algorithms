/* 
Given two strings determine if one is anagram of other
e.g iceman is anagram of cinema 
*/

import java.util.*;
public class AnagramDecider{
	public static void main(String [] args){
		AnagramDecider obj = new AnagramDecider();
		obj.test1();
		obj.test2();
		obj.test3();
		obj.test4();
	}

	private void test1(){
		test("Test1: => abc, abd => False", "abc", "abd", false);
	}

	private void test2(){
		test("Test2 => are, ear =>True", "are", "ear", true);
	}

	private void test3(){
		test("Test3 => iceman, cinema => True","cinema","iceman", true);
	}

	private void test4(){
		test("Test3 => icemann, cinema => False","cinema","icemann", false);
	}

	private void test(String testName, String first, String second, boolean expected){
		System.out.print(testName + " started....");

		if(expected == checkAnagram2(first, second)){
			System.out.println("pass");
		}
		else
			System.out.println("FAIL");
	}

	private boolean checkAnagram(String first, String second){
		if(first.length() != second.length()) return false;

		return sort(first).equalsIgnoreCase(sort(second));
	}

	private String sort(String str){
		if(str == null) return null;
		if(str.isEmpty() || str.length() == 1) return str;

		char [] chars = str.toCharArray();
		Arrays.sort(chars);
		//System.out.println(Arrays.toString(chars));
		return new String(chars);
	}

	private boolean checkAnagram2(String first, String second){
		if(first.length() != second.length()) return false;

		char [] first_str = first.toLowerCase().toCharArray();
		char [] seocond_str = second.toLowerCase().toCharArray();

		Map<Character, Integer> map = new HashMap<>();

		for(Character c: first_str){
			if(map.get(c) != null){
				map.put(c, map.get(c) + 1);
			}
			else{
				map.put(c, 1);
			}
		}

		for(Character c: seocond_str){
			if(map.get(c) != null){
				map.put(c, map.get(c) + 1);
			}
			else{
				map.put(c, 1);
			}
		}
		return checkForOddValueInMap(map);
	}

	private boolean checkForOddValueInMap(Map<Character,Integer> map){
		for(Integer n : map.values()){
			if(n % 2 !=0) return false;
		}
		return true;
	}

}