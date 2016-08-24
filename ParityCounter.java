/* Parity Counter */

public class ParityCounter{

	public static void main(String [] args){
		int x = 4;
		System.out.println("The parity in " + Integer.toBinaryString(x) + " is: " + getParity1(x));
	}

	private static int getParity(int x){
		int mask = 1;
		int res = 0;
		while(x != 0){
			System.out.println(" " + Integer.toBinaryString(x & mask));
			res ^= x & mask;
			x = x >> 1;
		}

		return res;
	}

}