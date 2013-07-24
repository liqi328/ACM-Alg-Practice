package pango;

import java.util.Scanner;

public class Possiblity {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] s = new String[10];
		s = str.split(" ");
		int a = Integer.parseInt(s[0]);
		int b = Integer.parseInt(s[1]);
		int c = Integer.parseInt(s[2]);
		int d = Integer.parseInt(s[3]);
		double p = Double.parseDouble(s[4]);
		System.out.println((int)(cal(a,b,c,d,p,1.0)*100));
		
	}
	
	public static double cal(int a,int b,int c,int d,double p,double k) {
		double sum = 0;
		
		if(b<d&&a>=c) {
			sum += k;
			return sum;
		}
		if(a<c)
			return 0;
		sum += cal(a-c,b+c,c,d,p,k*(1-p));
		sum += cal(a+d,b-d,c,d,p,k*p);
		return sum;
	}
}
