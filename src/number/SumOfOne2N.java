package number;

/**
 * 
 * 求1+2+…+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字
 * 以及条件判断语句（A?B:C）。
 * 
 * @author Liqi
 *
 */


class A{
	public static A[] array = new A[2];
	public int getSum(int n){
		return 0;
	}
}

class B extends A{
	public int getSum(int n){
		int i = n > 0? 1 : 0;
		return array[i].getSum(n - 1) + n; 
	}
}

public class SumOfOne2N {
	public static void main(String[] args){
		int n = 354;
		A.array[0] = new A();
		A.array[1] = new B();
		System.out.println(A.array[1].getSum(n));
	}
}
