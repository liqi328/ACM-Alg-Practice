package pango;

/**
 * 
 * 一个整型数组，数组里有正数也有负数。 数组中连续的一个或多个整数组成一个子数组，
 * 每个子数组都有一个和，求所有子数组的和的最大值，要求时间复杂度为O(n)。   
 * 例如输入的数组为1, -2, 3, 10, -4, 7, 2, -5，那么最大的子数组为3, 10, -4, 7, 2，
 * 因此输出为该子数组的和18， 请完成函数int MaxSum(int* a,int n)。 
 * 当全是负数的情况时，返回最大的那个负数
 * @author Liqi
 *
 */
public class MaxSubArraySum {
	public int run(int[] array){
		int sum = 0;
		int max = array[0];
		for(int i = 0; i < array.length; ++i){
			if(sum <= 0){
				sum = array[i];
			}else{
				sum += array[i];
			}
			if(sum > max){
				max = sum;
			}
		}
		
		return max;
	}
	
	public static void main(String[] args){
		//int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
		int array[] = {-3,-4,-2,-98};
		System.out.println(new MaxSubArraySum().run(array));
	}

}
