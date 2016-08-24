/* Check if input is balanced parenthesis or not */
import java.util.ArrayDeque;
import java.util.Deque;
public class CheckBalanced{
	
	private void test(String testName, String input, boolean expected){
		System.out.println(testName + " started...");

		if(expected == check(input)) print("pass");
		else print("FAIL");
	}

	private static void print(Object o){
		System.out.println(o);
	}

	private boolean check(String str){
		if(str == null || str.length() == 0) return true;
		if(str.length() == 1) return false;

		Deque<Character> stack = new ArrayDeque<>();

		for(Character c: str.toCharArray()){
			if(c == '(' || c =='{' || c == '['){
				stack.push(c);
			}
			else{
				if(stack.pop() != opposite(c)) return false;
			}
			
		}
		return stack.isEmpty();
	}

	private char opposite(char c){
		if (c == '(') return ')';
		else if(c == ')') return '(';
		else if(c == '{') return '}';
		else if(c =='}') return '{';
		else if(c == '[') return ']';
		else return '[';
	}
	public static void main(String [] args){
		CheckBalanced obj = new CheckBalanced();
		obj.test1();
		obj.test2();
	}

	private void test1(){
		test("Test1","{}()",true);
	}

	private void test2(){
		test("Test2","[{()}]",true);
	}

	/*
	{}()
	{()})
	{}(
	[]*/
}