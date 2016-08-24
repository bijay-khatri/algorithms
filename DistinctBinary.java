/* count all possible distinct binary of length N with no consecutive 1's 
   Example: 
    N = 1 => 0, 1
    N = 2 => 00, 10, 01
    N = 3 => 000, 100, 010, 001, 101 
    Procedure: Append 0 to all & append 1 to String that ends in 0
*/

import java.util.ArrayList;
public class DistinctBinary{
	public static void main(String [] args){
		DistinctBinary obj = new DistinctBinary();

		obj.test1();
		obj.test2();
		obj.test3();

	}

	private void test(String testName, int N, int expected){
		System.out.print(testName + " Started: ");
		print(distinctBinary(N));
		if(distinctBinary(N).size() == expected) print("pass");
		else print("FAIL");
	}

	private void test1(){
		test("Test1", 4, 8);
	}

	private void test2(){
		test("Test2", 5, 13);
	}

	private void test3(){
		test("Test3",0, 0);
	}

	private static void print(Object o){
		System.out.println(o);
	}

	private ArrayList<String> distinctBinary(int n){
		ArrayList<String> list = new ArrayList<>(); 
		if(n < 0) throw new IllegalArgumentException("Invalid length; Negative length");
		else if(n == 0){
			return list;
		}
		else if( n == 1){
			list.add("0");
			list.add("1");
			return list;
		}
		ArrayList<String> temp = distinctBinary(n - 1);  // n = 2 is in stack list with empty

		for(String word: temp){
			list.add(word + "0"); //"00","10"

			if(word.endsWith("0")){
				list.add(word + "1"); //"01"
			}
		}

		return list;
	}
}