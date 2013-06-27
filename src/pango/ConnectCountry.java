package pango;

import java.util.Scanner;

public class ConnectCountry {
	public static int calculate(int n){
		if(n == 2){
			return 1;
		}else if(n == 3){
			return 2;
		}
		int ret = (int)Math.round(1.249 * n * Math.log10(n));
		return ret;
	}
	
	public static void main(String[] args){
		int n = 0;
//		Scanner in = new Scanner(System.in);
//		n = in.nextInt();
//		
//		System.out.println(calculate(n));
		
		for(int i = 2; i <= 30; ++i){
			System.out.println(i+" : "+calculate(i) + ", " + (1.249 * i * Math.log10(i)));
		}
	}
}
