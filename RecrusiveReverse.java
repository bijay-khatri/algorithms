/* Recursively reverse the given string */
public class RecrusiveReverse{
	
	public void test(String testName, String input, String reverse, boolean expected){
		System.out.print(testName + " started....");

		if(expected == (reverse.equals(reverse(input)))) print("pass");
		else print("fail");
	}
	
	private static void print(Object o){
		System.out.println(o);
	}

	private String reverse(String str){
		if(str == null) throw new NullPointerException("Null cannot be passed to String");
		//Base Case
		if(str == "" || str.length() == 1) return str;

		return str.substring(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
	}

	public static void main(String [] args){
		RecrusiveReverse obj = new RecrusiveReverse();
		obj.test1();
		obj.test2();
		obj.test3();
		obj.test4();
		obj.test5();
	}

	private void test1(){
		test("Test1","","", true);
	}

	private void test2(){
		test("Test2","A","A", true);
	}

	private void test3(){
		test("Test3","CAT","TAC", true);
	}

	private void test4(){
		test("Test4","BBBABB","",false);
	}

	private void test5(){
		test("Test5", "MADAM","MADAM", true);
	}

}