package pango;
/*
 * 一般地我们有“灌水定理”：
　　“如果有n个壶容积分别为A1，A2，……，An（Ai均为大于0的整数）设w为另一大于0的整数。则用此n个壶可倒出w升水的充要条件为：
　　1)　w小于等于A1+A2+......+An；
　　2)　w可被(A1,A2,......,An)（这n个数的最大公约数）整除。”
 * */
public class PourWater {
	
	public static void main(String[] args){
		System.out.println(can(5, 6, 3));
		
		System.out.println(can(65, 78, 38));
		System.out.println(can(65, 78, 39));
		System.out.println(can(1, 2, 1000000000));
	}
	
	public static boolean can(int a,int b,int c){
		boolean flag = false;
//		if(c > a + b){
//			return flag;
//		}
		
		int g = gcd(a, b);
		
		if(c%g == 0){
			flag = true;
		}
		return flag;
	}
	
	private static int gcd(int a, int b){
		if(a<b){
			return gcd(b,a);
		}
		if(b==0) return a;
		
		if(isEven(a)){
			if(isEven(b)){
				return gcd(a>>1,b>>1)<<1;
			}else{
				return gcd(a>>1,b);
			}
		}else{
			if(isEven(b)){
				return gcd(a,b>>1);
			}else{
				return gcd(a-b,b);
			}
		}
	}
	
	private static boolean isEven(int i){
		return (i&1)!=1;
	}
}
