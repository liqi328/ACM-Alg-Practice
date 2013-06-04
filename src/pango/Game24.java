package pango;

/**
 * 24����Ϸ��һ��ʹ���˿��������е���������Ϸ��
 * ��Ϸ�����ǣ���һ���˿����г�ȥ��С��ʣ��52�ţ�
 * �����ȡ4���ƣ��������ϵ�����A����1�����üӡ������ˡ��������Ž�������ó�24��
 * ÿ���ƶ�����ʹ��һ�Σ��������ظ�ʹ�á� 
 * ��Щ����в�ͬ���㷨������Ҫ��2��4��6��12��������ϳ�24�㣬
 * ���������¼�����Ϸ����� 2 + 4 + 6 + 12 = 24  4 �� 6 �� 2 + 12 = 24  
 * 12 �� 4 �� (6 + 2) = 24 ��Ȼ��Ҳ��Щ����㲻��24����1��1��1��1 �� 6��7��8��8����ϡ�
 * �� --��Ŀ��������wikipedia��http://zh.wikipedia.org/wiki/24%E7%82%B9�� 
 * ����ɺ���can24��4��������������24�㣬����1�������򷵻�0�� 
 * �������ѣ� ע��������Щ��ϣ� 
 * 1 1 1 10    �����ԣ� 6 6 6 6     ���ԣ�
 *  5 5 5 1 ���ԣ��������÷�������(5-1/5)*5 = 24�� 1 1 1 11   ���ԣ� 
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
