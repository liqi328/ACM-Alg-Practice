package pango;

import java.math.BigInteger;
import java.util.Arrays;



public class Palindrome {
	public static long counter = 0L;
	
	public static void permutation(char[] source, int cur){
		if(cur == source.length){
			++counter;
			return;
		}
		
		for(int i = cur; i < source.length; ++i){
			if(isCanSwap(source, cur, i)){
				swap(source, cur, i);
				permutation(source, cur + 1);
				swap(source, cur, i);
			}
		}
	}
	
	public static boolean isCanSwap(char[] source, int start, int end){
		for(int i = start; i < end; ++i){
			if(source[i] == source[end]){
				return false;
			}
		}
		return true;
	}
	
	public static void swap(char[] source, int i, int j){
		char tmp = source[i];
		source[i] = source[j];
		source[j] = tmp;
	}
	
	
	public static boolean isPalindrome(char[] source){
		for(int i = 0, j = source.length - 1; i < j; ++i, --j){
			if(source[i] != source[j]){
				return false;
			}
		}
		return true;
	}
	
	public static BigInteger factorial(int n) {
		BigInteger result = new BigInteger("1");
		if (n < 0) {
			System.err.println("n must be great than 0");
			return new BigInteger("-1");
		} else if (n == 0) {
			return new BigInteger("1");
		} else {
			for (int i = 1; i <= n; i++) {
				BigInteger num = new BigInteger(String.valueOf(i));
				result = result.multiply(num);
			}
			return result;
		}
	}
	
	public static int palindrome(String s){
		int[] index = new int[26];
		Arrays.fill(index, 0);
		for(char c : s.toCharArray()){
			index[c - 'a']++;
		}
		
		int oddCount = 0; //奇数的个数
		
		for(int i = 0; i < index.length; ++i){
			if(index[i] % 2 != 0){
				oddCount++;
			}
		}
		
		if(oddCount > 1){
			return 0;
		}
		
		BigInteger result = factorial(s.length() / 2);//为result赋初始值，为1   
		
		BigInteger divisor = new BigInteger("1");
		for(int i = 0; i < index.length; ++i){
			if(index[i] > 1){
				divisor = divisor.multiply(factorial((index[i] / 2)));
			}
		}
		result = result.divide(divisor);
		result = result.mod(new BigInteger("1000000007"));
		return result.intValue();
	}
	
	public static void main(String[] args){
		String source = "a";
		System.out.println(palindrome(source));
		
		source = "ab";
		System.out.println(palindrome(source));
		
		source = "aabb";
		System.out.println(palindrome(source));
		
		source = "aabbb";
		System.out.println(palindrome(source));
		
		source = "aaabbb";
		System.out.println(palindrome(source));
		
		source = "aaabbbb";
		System.out.println(palindrome(source));
		
		source = "aabbc";
		System.out.println(palindrome(source));
		
		source = "aaaabbbbc";
		System.out.println(palindrome(source));
		
		source = "hqaymehhrsfuqrpahrimsxftuxqrpsejouuehaqtsryxjhearxmogmi";//676517829
		System.out.println(palindrome(source));
		
//		StringBuffer sb = new StringBuffer();
//		for(char i = 'a'; i <='z'; ++i){
//			sb.append(i);
//		}
//		for(char i = 'a'; i <='z'; ++i){
//			sb.append(i);
//		}
//		
//		System.out.println(palindrome(sb.toString()));
	}
}
