package pango;

/**
 * �Һܾ��ȣ����㹻��ʱ���ڣ�
 * ֻ�д�Լ10%��רҵ����Ա���԰����С����д�ԡ�
 * ��д�������С����Ļ���ֹ��Щ�ˣ�
 * �ߵ����ڡ������������Ƶ����� ��3�� ����Ͳ��ҡ�
 * ��6.2.1�ڵġ���ʷ��ο����ס�����ָ����
 * ��Ȼ����1946������˽����ֲ��ҵķ�������������
 * ��ֱ��1962�������д��û��bug�Ķ��ֲ��ҳ��� 
 * �������Ƕ�������������������ᣨ��1�棩����35-36ҳ�� ��ʵ�ֶ��ֲ��ң�
 * 
 * @author Liqi
 *
 */
public class BinarySearch {
	
	/**
	 * @param array
	 * @param key Ҫ���ҵ���ֵ
	 * @return �ҵ��ˣ������ҵ��������±꣨�����ظ�Ԫ��ʱ��������С���±꣩��û�ҵ�������-1
	 */
	public int run(int[] array, int key){
		int low = 0;
		int high = array.length - 1;
		int mid = 0;
		while(low <= high){
			//mid = (low + high) / 2;
			mid = low + ((high - low) >> 1);
			if(array[mid] > key){
				high = mid - 1;
			}else if(array[mid] < key ){
				low = mid + 1;
			}else{
				while(mid > low && array[mid - 1] == key){
					--mid;
				}
				return mid;
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		int array[] = {1,5,5,5,5,5,5,5,7,9,9,9,9,9,11,12,156};
		BinarySearch searcher = new BinarySearch();

		System.out.println(searcher.run(array, 9));
		System.out.println(searcher.run(array, 10));
		System.out.println(searcher.run(array, 0));
		System.out.println(searcher.run(array, 1));
		System.out.println(searcher.run(array, 5));
		System.out.println(searcher.run(array, 12));
		System.out.println(searcher.run(array, 156));
		System.out.println(searcher.run(array, 157));
	}

}
