package pango;

/**
 * 24点游戏是一种使用扑克牌来进行的益智类游戏，
 * 游戏内容是：从一副扑克牌中抽去大小王剩下52张，
 * 任意抽取4张牌，把牌面上的数（A代表1）运用加、减、乘、除和括号进行运算得出24。
 * 每张牌都必须使用一次，但不能重复使用。 
 * 有些组合有不同种算法，例如要用2，4，6，12四张牌组合成24点，
 * 可以有如下几种组合方法： 2 + 4 + 6 + 12 = 24  4 × 6 ÷ 2 + 12 = 24  
 * 12 ÷ 4 × (6 + 2) = 24 当然，也有些组合算不出24，如1、1、1、1 和 6、7、8、8等组合。
 * ” --题目描述来自wikipedia：http://zh.wikipedia.org/wiki/24%E7%82%B9。 
 * 请完成函数can24，4张牌如果可以组成24点，返回1，不能则返回0。 
 * 友情提醒： 注意以下这些组合： 
 * 1 1 1 10    不可以； 6 6 6 6     可以；
 *  5 5 5 1 可以，即可以用分数，如(5-1/5)*5 = 24； 1 1 1 11   可以； 
 * 
 * @author Liqi
 *
 */
public class Game24 {

	public static boolean point24(double number[], int n){
		if(n == 1){
			//if(Double.doubleToLongBits(number[0] - 24) == 0L){
			if(Math.abs(number[0] - 24) < 1e-8){
				return true;
			}
			return false;
		}
		for(int i = 0; i < n; ++i){
			for(int j = i + 1; j < n; ++j){
				double a = number[i];
				double b = number[j];
				
				number[j] = number[n - 1];
				
				number[i] = a + b;
				if(point24(number, n - 1)){
					return true;
				}
				
				number[i] = a - b;
				if(point24(number, n - 1)){
					return true;
				}
				
				number[i] = b - a;
				if(point24(number, n - 1)){
					return true;
				}
				
				number[i] = a * b;
				if(point24(number, n - 1)){
					return true;
				}
				//if(Double.doubleToLongBits(b) != 0L){
				if(Math.abs(b) > 1e-8){
					number[i] = a / b;
					if(point24(number, n - 1)){
						return true;
					}
				}
				
				//if(Double.doubleToLongBits(a) != 0L){
				if(Math.abs(a) > 1e-8){
					number[i] = b / a;
					if(point24(number, n - 1)){
						return true;
					}
				}
				
				number[i] = a;
				number[j] = b;
			}
		}
		return false;
	}
	
	public static int can24(int a, int b, int c, int d){
		double[] number = new double[4];
		number[0] = a;
		number[1] = b;
		number[2] = c;
		number[3] = d;
		if(point24(number, 4)){
			return 1;
		}
		return 0;
	}
	
	public static void main(String[] args){
		System.out.println(can24(5, 5, 5, 1));
		System.out.println(can24(3, 3, 7, 7));
		System.out.println(can24(4, 4, 10, 10));
		System.out.println(can24(1, 4, 5, 6));
		System.out.println(can24(3, 8, 8, 10));
		System.out.println(can24(9, 9, 6, 2));
		System.out.println(can24(3, 3, 8, 8));
		System.out.println(can24(3, 8, 3, 8));
		System.out.println(can24(0, 8, 3, 0));
		System.out.println(can24(0, 5, 3, 2));
		System.out.println(Double.doubleToLongBits(0.1));
		System.out.println(Double.doubleToLongBits(0.01));
		System.out.println(Double.doubleToLongBits(0.001));
		System.out.println(Double.doubleToLongBits(0.0000000001));
		System.out.println(Double.doubleToLongBits(0));
	}
}
