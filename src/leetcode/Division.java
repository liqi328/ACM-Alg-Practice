package leetcode;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * @author Liqi
 *
 */
/**
 * @author Liqi
 *
 */
public class Division {
	
	/**
	 * 不用乘除，取余，实现两个数相除
	 * 
	 * @param dividend	被除数
	 * @param divisor	除数
	 * @return
	 */
	public static int divide(int dividend, int divisor){
		if(dividend == 0 || divisor == 0){
			return 0;
		}
		
		/*
		 * 若dividend == divisor 等于最小的负数, 直接放回1;
		 * 保证后面两个数同时为负数时，两个数不会同时是最小的负数;
		 * */
		if(dividend == divisor){
			return 1;
		}
		if(divisor == 1){
			return dividend;
		}
		
		boolean positive = true; /* 正数=true */ 
		int result = 0;
		
		/*
		 * 除数 > 0, 被除数 < 0
		 * */
		if(dividend < 0 && divisor > 0){
			/* 
			 * 若 求-3/5 = 0, 则-3 + 5 = 2 > 0; 
			 * 
			 * 由于 dividend += divisor; 所以 dividend一定不会是最小的负数
			 * */
			if((dividend += divisor) > 0){
				return 0;
			}
			positive = false;
			result = 1;
			dividend = -dividend;
		}else if(dividend > 0 && divisor < 0){   //除数 < 0, 被除数 > 0
			/*
			 * divisor 若是最小的负数，则 dividend += divesor 一定会< 0
			 * */
			if((dividend += divisor) < 0){
				return 0;
			}
			positive = false;
			result = 1;
			divisor = -divisor;
		}else if(dividend < 0 && divisor < 0){	//除数 , 被除数 都为负数 
			if((dividend -= divisor) > 0){
				return 0;
			}
			positive = true;
			result = 1;
			dividend = -dividend;
			divisor = -divisor;
		}
		
		int x, y;
		while(dividend >= divisor){
			for(x = divisor, y = 1; dividend - x >= x; x+=x, y+=y);
			result += y;
			dividend -= x;
		}
		
		result = positive ? result : -result;
		
		return result;
	}
	
	/**
	 * 写一个函数，求两个整数的之和，要求在函数体内不得使用＋、－、×、÷
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int add(int a, int b){
		
		if(b == 0){
			return a;
		}
		
		int sum = a ^ b;
		int carry = (a & b) << 1;
		return add(sum, carry);
	}
	
	public static int add_2(int a, int b){
		int tmp = 0;
		while(b != 0){
			tmp = a ^ b;
			b = (a & b) << 1;
			a= tmp;
		}
		return a;
	}
	

	
	public static void main(String[] args){
		int[] dividend = {-2147483648, 1004958205};
		int[] divisor = {-3, -2137325331};
		int[] result = {715827882, 0};
		
		
		for(int i = 0; i < dividend.length; ++i){
			System.out.println(divide(dividend[i], divisor[i]));
		}
		
		
		int a = 17;
		int b = 24;
		System.out.println(add(a, b));
		System.out.println(add_2(a, b));
		
	}

}
