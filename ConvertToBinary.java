/* Convert a number into binary representation and count the number of 1s */

public class ConvertToBinary{
	private void test(String testName, int number, String binary, boolean expected){
		print(testName + " Begins: " );
		if(Integer.toBinaryString(number).equals(convertToBinary(number))){
			print("pass");
		}
		else
			print("FAIL");
	}

	private void test1(){
		test("Test1", 8, "1000", true);
	}

	private void test2(){
		test("Test2", 31, "11111", true);
	}



	private static void print(Object o){
		System.out.println(o);
	}

	public static void main(String [] args){
		ConvertToBinary obj = new ConvertToBinary();
		obj.test1();
		obj.test2();

		obj.countOnesDiff(12,15);
	}

	private String convertToBinary(int num){
		StringBuilder sb = new StringBuilder();
		while(num != 0){
			sb.append(num % 2);
			num /= 2;
		}

		return sb.reverse().toString();
	}

	private int countOnes(String binary){
		int num = Integer.parseInt(binary,2);
		int mask = 1;
		int count = 0;
		while(num !=0){
			count += num & mask;
			num = num >> 1;
		}
		return count;
	}

	private int countOnesDiff(int num1, int num2){
		int res = num1 ^ num2;
		print("Difference : " + countOnes(Integer.toBinaryString(res)));
		return countOnes(Integer.toBinaryString(res));
	}
}