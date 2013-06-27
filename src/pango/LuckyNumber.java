package pango;

import java.util.Scanner;

public class LuckyNumber {
	static int a[]=new int[500000+1];
	static void lucky(int start,int a[],int len)
	{
		int k=start,num=a[start];
		for(int i=k;i<len;i++)
		{
			if(i%num!=0) a[k++]=a[i];
		}
		if(num<len)lucky(start+1,a,k);
	}
	public static void main(String[] args)
	{
		
		int len=500000,kinds=0;
		for(int i=1;i<len;i++) a[i]=2*i-1;
		lucky(2,a,len);
		Scanner cin=new Scanner(System.in);
		int m=cin.nextInt();
		int n=cin.nextInt();
		long sta=System.currentTimeMillis();
		for(int i=1;i<len;i++)
		{
			if(a[i]>m && a[i]<n)  kinds++;
			if(a[i]>=n) break;
		}
		System.out.println(kinds);
		System.out.println(System.currentTimeMillis()-sta);//时间
	}
}
