/*
You are given an array of characters arr, which consists of sequences of characters (words) separated by space characters.
How can you most efficiently reverse the order of words in the sentence?
Explain and code your solution and analyze the runtime and space complexity.

For example:
[ 'p', 'e', 'r', 'f', 'e', 'c', 't', '  ', 'm', 'a', 'k', 'e', 's', '  ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' ]

would turn into:
[ 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', '  ', 'm', 'a', 'k', 'e', 's', '  ', 'p', 'e', 'r', 'f', 'e', 'c', 't' ]*/
//Time Complexity :O(n)
//Space Complexity : 0(1)

import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

public class ReverseString{
	public static void main(String [] args){
		String str = "I am going to study hard";
		
		char [] ans = reverse(str.toCharArray());
		char [] res = reverseWord(ans);

		System.out.println("Reverse word is : " + Arrays.toString(res));

		//Using Library with Stack
		printReverse(str);

	}

	private static void printReverse(String str){
		if(str.isEmpty() || str == null) throw new IllegalArgumentException("Invalid Word");
		if(str.length() == 1) return;

		String [] words = str.split(" ");

		Deque<String> stack = new ArrayDeque<>();

		for(String w: words)
			stack.push(w);

		while(!stack.isEmpty()){
			System.out.print(stack.pop() + "\t");
		}
	}


	private static void reverse(char [] words, int start, int end){
		while(start < end){
			char temp = words[start];
			words[start] = words[end];
			words[end] = temp;
			start++;
			end--;
		}
	}

	private static char [] reverse(char [] words){
		if(words == null || words.length == 0) throw new IllegalArgumentException("Invalid word");
		if(words.length == 1) return words;

		for(int i = 0; i < words.length / 2; i++){
			char temp = words[i];
			words[i] = words[words.length - 1 - i];
			words[words.length - 1 - i] = temp;
		}
		return words;
	}

	private static char [] reverseWord(char[] words){
		int start_pos = 0;
		for(int i = 0; i < words.length; i++){
			if(words[i] ==' ' && i < words.length - 1){
				reverse(words, start_pos, i - 1);
				start_pos = i + 1;
			}
			else if(i == words.length - 1){
				reverse(words,start_pos,i);
			}
		}
		return words;
	}


}