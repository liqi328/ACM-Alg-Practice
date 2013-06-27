package number;

import java.util.Arrays;

/**
 * 给定一个数组a[N]，我们希望构造数组b [N]，其中b[j]=a[0]*a[1]…a[N-1] / a[j]，在构造过程中，
 * 不允许使用除法：要求O（1）空间复杂度和O（n）的时间复杂度；
 * 除遍历计数器与a[N] b[N]外，不可使用新的变量（包括栈临时变量、堆空间和全局静态变量等）
 
解析：设b[0]=1
由b[i]=b[i-1]*a[i-1]可得
b[1] = a[0]
b[2] = a[0]a[1]
…
b[i] = a[0]a[1]a[2]…a[i-1]
…
b[n-1] = a[0]a[1]…a[n-2]
那么再通过b[0]这个变量来迭代出1, a[n-1], a[n-2]a[n-1], a[n-3]a[n-2]a[n-1], … , 
a[1]a[2]a[3]…a[n-1]，迭代过程中分别乘以b[n-1], b[n-2], … , b[0]
代码如下
 * 
 * @author Liqi
 *
 */
public class MutiplyN_1 {
	
	public static void caculate(int[] array, int[] result){
		result[0] = 1;
		for(int i = 1; i < array.length; ++i){
			result[i] = result[i - 1] * array[i - 1 ];
		}
		
		for(int i = array.length - 1; i >= 1 ; --i){
			result[i] *= result[0];
			result[0] *= array[i];
		}
	}
	
	public static void main(String[] args){
		int a[] = {2,3,4,5};  
	    int b[] = {0,0,0,0};  
	    caculate(a, b);
	    System.out.println(Arrays.toString(b));
	}

}
