package pango;

public class GCD {

	public static void main(String[] args) {
		int gcd = solutionGcd5(30,42);
		System.out.println(gcd);
	}

	private static int solutionGcd(int a, int b) {
		int c = 0;
		boolean flag = true;
		if (a < b) {
			c = a;
			a = b;
			b = c;
		}
		while (flag) {
			c = a % b;
			if (c != 0) {
				a = b;
				b = c;
			} else {
				flag = false;
			}
		}
		return b;

	}
	private static int solutionGcd2(int a, int b){
		return b==0?a:solutionGcd2(b,a % b);
	}
	private static int solutionGcd3(int a, int b){
		int c1 =0, c2=0;
		boolean flag = true;
		int k = 1;
		while(flag){
			c1=a-k*b;
			if(c1>0){
				k= k +1; c2=c1;
			}else{
				flag=false;
			}
		}
		return c2==0?a:solutionGcd3(b,c2);
	}
	private static int solutionGcd4(int a, int b){
		if(a<b){
			return solutionGcd4(b,a);
		}
		if(b==0) return a;
		return solutionGcd4(a-b,b);
	}
	private static int solutionGcd5(int a, int b){
		if(a<b){
			return solutionGcd5(b,a);
		}
		if(b==0) return a;
		
		if(isEven(a)){
			if(isEven(b)){
				return solutionGcd5(a>>1,b>>1)<<1;
			}else{
				return solutionGcd5(a>>1,b);
			}
		}else{
			if(isEven(b)){
				return solutionGcd5(a,b>>1);
			}else{
				return solutionGcd5(a-b,b);
			}
		}
	}
	private static boolean isEven(int i){
		return (i&1)!=1;
	}
	
}

