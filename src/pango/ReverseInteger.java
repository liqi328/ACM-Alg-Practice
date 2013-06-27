package pango;


public class ReverseInteger {
//	String str = Integer.toString(num);
//	char[] cstr = str.toCharArray();
//	boolean flag = str.charAt(0) == '-' ? true : false;
//	int i = flag ? 1 : 0;
//	char t = '0';
//	for(int j = str.length() - 1; i < j  ; ++i, --j){
//		t = cstr[i];
//		cstr[i] = cstr[j];
//		cstr[j] = t;
//	}
//	num = Integer.valueOf(String.valueOf(cstr));
//	//System.out.println(num);
//	return num;
	public static int reverse(int num){
		//String str = Integer.toString(num);
		char[] cstr = Integer.toString(num).toCharArray();
		boolean flag = cstr[0] == '-' ? true : false;
		int i = cstr[0] == '-' ? 1 : 0;
		char t = 0;
		for(int j = cstr.length - 1; i < j  ; ++i, --j){
			t = cstr[i];
			cstr[i] = cstr[j];
			cstr[j] = t;
		}
		num = Integer.valueOf(String.valueOf(cstr));
		System.out.println(num);
		return num;
	}
	
	public static void main(String[] args){
		int num = -321;
		num  = 987230987;
		reverse(num);
		//System.out.println(Integer.toString(num));
	}
}
