/* 1. Count the number of permutations of the word 
   e.g input 'A' -> 1
   e.g input 'AB' -> 2
   e.g input 'ABC' -> 6
*/
import java.util.ArrayList;
public class NumberOfPermutation{
	public void test(String testName, String str, int number, boolean expected){
		System.out.print(testName + " started ");
		//print("NO: " + countPermutation(str));
		if(expected == (number == countPermutation(str))) print("pass");
		else print("FAIL");
	}

	private static void print(Object o){
		System.out.println(o);
	}
	
	private int countPermutation(String str){
		ArrayList<String> result = new ArrayList<>();
		result = permutate(str);
		//print(result);
		return result.size();
	}

	private ArrayList<String> permutate(String str){
		ArrayList<String> result = new ArrayList<>();
		if(str == "" || str == null){
			result.add("");
			return result;
		}

		if(str.length() == 1) {
			result.add(str);
			return result;
		}

		char first = str.charAt(0);
		String rem = str.substring(1);

		ArrayList<String> temp = permutate(rem);

		for(String t : temp){
			for(int i = 0; i <= t.length(); i++){
				result.add(insertCharAt(i,first,t));
			}
		}
		return result;
	}

	private String insertCharAt(int index, char c, String str){
		String first = str.substring(0, index);
		String last = str.substring(index);
		return first + c + last;
	}

	public static void main(String [] args){
		NumberOfPermutation obj = new NumberOfPermutation();
		obj.test1();
		obj.test2();
		obj.test3();
		obj.test4();
		obj.test5();
	}

	private void test1(){
		test("Test1","A", 1, true);
	}

	private void test2(){
		test("Test2", "A", 0, false);
	}

	private void test3(){
		test("Test3","A",1, true);
	}

	private void test4(){
		test("Test4", "ABC", 6, true);
	}

	private void test5(){
		test("Test5", "CC", 2, true);
	}
}