package pango;

import java.math.BigInteger;
import java.util.Arrays;

public class StringPermutation {
	public static int counter = 0;
	public static int permutation(String source){
		counter = 0;
		permutation_2(source.toCharArray(), 0);
		return 0;
	}
	
	public static void permutation_1(char[] source, int cur){
		if(cur == source.length){
			System.out.println(source);
			++counter;
			return;
		}
		
		for(int i = cur; i < source.length; ++i){
			swap(source, cur, i);
			permutation_1(source, cur + 1);
			swap(source, cur, i);
		}
	}
	
	public static void permutation_2(char[] source, int cur){
		if(cur == source.length){
			//System.out.println(source);
			++counter;
			return;
		}
		
		for(int i = cur; i < source.length; ++i){
			if(isCanSwap(source, cur, i)){
				swap(source, cur, i);
				permutation_2(source, cur + 1);
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
	
	public static long countPermutation(String source){
		BigInteger result = new BigInteger("1");//为result赋初始值，为1   
		for (int i = 1; i <= source.length(); i++) {   
			BigInteger num = new BigInteger(String.valueOf(i));   
			result = result.multiply(num);//调用自乘方法   
	    }
		
		int[] index = new int[26];
		Arrays.fill(index, 0);
		for(char c : source.toCharArray()){
			index[c - 'a']++;
		}

		for(int i = 0; i < index.length; ++i){
			if(index[i] > 0){
				result = result.divide(new BigInteger("" + index[i]));
			}
		}
		
		return result.longValue();
	}
	
	public static void main(String[] args){
		String s = "aabb";
		
		permutation(s);
		System.out.println(counter);
		System.out.println("--> " + countPermutation(s));
		
		StringBuffer sb = new StringBuffer();
		for(char i = 'a'; i <='z'; ++i){
			sb.append(i);
		}
		System.out.println("--> " + countPermutation(sb.toString()));
		for(char i = 'a'; i <='z'; ++i){
			sb.append(i);
		}
		System.out.println("--> " + countPermutation(sb.toString()));
		//permutation(sb.toString());
		System.out.println(counter);
	}

}
