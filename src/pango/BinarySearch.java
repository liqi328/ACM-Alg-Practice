package pango;

/**
 * 我很惊讶：在足够的时间内，
 * 只有大约10%的专业程序员可以把这个小程序写对。
 * 但写不对这个小程序的还不止这些人：
 * 高德纳在《计算机程序设计的艺术 第3卷 排序和查找》
 * 第6.2.1节的“历史与参考文献”部分指出，
 * 虽然早在1946年就有人将二分查找的方法公诸于世，
 * 但直到1962年才有人写出没有bug的二分查找程序。 
 * ”——乔恩·本特利，《编程珠玑（第1版）》第35-36页。 请实现二分查找，
 * 
 * @author Liqi
 *
 */
public class BinarySearch {
	
	/**
	 * @param array
	 * @param key 要查找的数值
	 * @return 找到了，返回找到的数的下标（存在重复元素时，返回最小的下标），没找到，返回-1
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
