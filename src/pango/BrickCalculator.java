package pango;

public class BrickCalculator {
	static long total = 0;
	static int[] brick = new int[1024*5];
	
	static void countBrick(int deep,int n,int k){
		if (deep >= k*n){
		  total++;
		  return;
		}
		if (brick[deep] == 0){
			brick[deep] = 1;
			countBrick(deep+1,n,k);
			brick[deep] = 0;
			if ((deep+1)%k > 0 && (deep+1)<k*n){
				if (brick[deep+1] == 0){
				brick[deep] = 1;
				brick[deep+1] = 1;
				countBrick(deep+2,n,k);
				brick[deep] = 0;
				brick[deep+1] = 0;
				}
			}
			if (deep+k < k*n){
				if (brick[deep+k] == 0){
					brick[deep] = 1;
					brick[deep+k] = 1;
					countBrick(deep+1,n,k);
					brick[deep] = 0;
					brick[deep+k] = 0;
				}
			}
		}else{
			countBrick(deep+1,n,k);
		}
	}
	
	public static long calculate(int n,int k) {
		total = 0;
		//countBrick(0,(int)Math.pow((double)2,n),k);
		countBrick(0,n,k);
		return total;
    }


    //start ��ʾ���Զ��ľ���ʼΨһ��ʶ������ɾ������ӡ� 
    public static void main(String args[]) { 
    	for (int i = 0;i < 8;i++){
 		   for (int j = 1; j <= 2; j++){
 		       System.out.println("N: " + i + "\tK: " + j + " -> "+ calculate(i,j) +"��");
 		   }
 	   }
    } 
    //end //��ʾ���Զ��ľ����Ψһ��ʶ������ɾ������ӡ�
}
