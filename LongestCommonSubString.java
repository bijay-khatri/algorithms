/*
Given two strings S1 and S2, find longest common substrings between them.

For example:-
S1 = "LCLC", S2="CLCL".

LCS = {"LCL", "CLC"}
*/

import java.util.ArrayList;
public class LongestCommonSubString{
	
	private void test(String testName, String str1, String str2, String expected){
		System.out.print(testName + " Begins: ");
		print(lcs(str1,str2));
		if(expected.equals((lcs(str1, str2).get(0)))){
			print("pass");
		}
		else{
			print("FAILED");
		}
	}

	private void test1(){
		test("Test1","ABAD","BADA", "BAD");
	}
	private void test2(){
		test("Test2","DDBAD","ADA", "AD");
	}
	private static void print(Object o){
		System.out.println(o);
	}

	public static void main(String [] args){
		LongestCommonSubString obj = new LongestCommonSubString();
		obj.test1();
		obj.test2();

		//for Longest Common Subsequence
		print(obj.getLcs("ABCDE","ACE"));
		print(" Test = " + (obj.getLcs("ABCDE","ACE") == 3));
	}

	private int getLcs(String str1, String str2){
		int len1 = str1.length();
		int len2 = str2.length();

		int [][] memo = new int[len1][len2];

		if(len1 == 0 || len2 ==0) return 0;

		for(int i = 0; i < len1; i++){
			for(int j = 0; j < len2; j++){
				
				if(i == 0 || j == 0) memo[i][j] = 0;
				
				else if(str1.charAt(i - 1) == str2.charAt(j - 1)){
					memo[i][j] = 1 + memo[i-1][j-1];
				}
				else{

					memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
				}
			}
		}
		return memo[len1 - 1][len2 - 1];
	}

	private ArrayList<String> lcs(String str1, String str2){
		int len1 = str1.length();
		int len2 = str2.length();

		if(len1 == 0 || len2 == 0) throw new IllegalArgumentException("Invalid Input");

		int [][] memo = new int [len1][len2];

		int max = Integer.MIN_VALUE;
		ArrayList<String> result = null;

		for(int i = 0; i < len1; i++){
			for(int j =0; j < len2; j++){
				if(str1.charAt(i) == str2.charAt(j)) {
					
					if(i == 0 || j == 0) 
						memo[i][j] = 1;
					else 
						memo[i][j] = memo[i - 1][j - 1] + 1;

					if(max < memo[i][j]){
						max = memo[i][j];
						result = new ArrayList<>();
						result.add(str1.substring(i - max + 1, i + 1));
					}
					else if(max == memo[i][j]){
						result.add(str1.substring(i - max + 1, i + 1));
					}
				}
				else{
					memo[i][j] = 0;
				}
		}
	}
	return result;
}
}