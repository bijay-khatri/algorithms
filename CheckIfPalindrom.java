/* Program to check if a string is palindrom or not */

public class CheckIfPalindrom
{
	public static void main(String [] args){
		test1();
		test2();
		test3();
		test4();
		test5();
	}

	private static void test(String testName, String input, boolean expected){
		System.out.print(testName + " Started ... ");

		if(expected == checkPalindrome(input)) print("pass");
		else print("FAIL");
	} 

	private static void print(Object o){
		System.out.println(o);
	}

	private static boolean checkPalindrome(String str){
		if(str == null) throw new NullPointerException(" Null String not accepted");
		if(str == "" || str.length() == 1) return true;

		int len = str.length() - 1;
		int last = len;
		for(int i = 0; i <= len / 2 ; i++){
			if(str.charAt(i) != str.charAt(last--)) return false;
		}
		return true;
	}

	private static void test1(){
		test("Test1 -> Empty String","", true);
	}

	private static void test2(){
		test("Test2 -> Single Character String","A", true);
	}

	private static void test3(){
		test("Test3 -> String : cat","cat", false);
	}

	private static void test4(){
		test("Test4 -> String: madam","madam", true);
	}

	private static void test5(){
		test("Test5 -> String: goog","goog", true);
	}
}