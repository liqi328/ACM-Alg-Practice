package pango;

/**
 * 
 * һ���������飬������������Ҳ�и����� ������������һ�������������һ�������飬
 * ÿ�������鶼��һ���ͣ�������������ĺ͵����ֵ��Ҫ��ʱ�临�Ӷ�ΪO(n)��   
 * �������������Ϊ1, -2, 3, 10, -4, 7, 2, -5����ô����������Ϊ3, 10, -4, 7, 2��
 * ������Ϊ��������ĺ�18�� ����ɺ���int MaxSum(int* a,int n)�� 
 * ��ȫ�Ǹ��������ʱ�����������Ǹ�����
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
