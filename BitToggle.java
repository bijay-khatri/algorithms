/*Given a number N toggle all the bits to the right of the most significant bit (MSB) bit 
(and including MSB also) in the binary representation of the number.
Input will be an integer, N */

public class BitToggle{
	public static void main(String [] args){
		int N = 10;
		System.out.print(toggle(N));
	}

	private static String toggle(int N){
		int mask = 1 + ~1; // 2's Complement = 1's + 1
		System.out.println("Before: " + Integer.toBinaryString(N));
		int num = N ^ mask;
		return Integer.toBinaryString(num);
	}
}