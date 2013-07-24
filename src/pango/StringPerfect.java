package pango;

import java.util.Arrays;

public class StringPerfect {
	public static int perfect(String s){
		s = s.toLowerCase();
		int[] counter = new int[26];
		Arrays.fill(counter, 0);
		
		for(char c : s.toCharArray()){
			counter[c - 'a']++;
		}
		
		Arrays.sort(counter);
		int result = 0;
		int base = 26;
		for(int i = counter.length - 1; i >= 0; --i){
			result += counter[i] * base;
			--base;
		}
		return result;
	}

	
	public static void main(String[] args){
		System.out.println(perfect(""));
		System.out.println(perfect("dad"));
		System.out.println(perfect("abdcdsadf"));
		System.out.println(perfect("uxmyzaeuXbyzy"));
	}
}
