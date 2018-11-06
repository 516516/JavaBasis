package demo5_1;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		int N,M,S;
		Scanner scanner=new Scanner(System.in);
		N=scanner.nextInt();
		M=scanner.nextInt();
		S=scanner.nextInt();
		
		int n[]=new int[N];
		for(int i=0;i<N;i++) {
			n[i]=1;
		}
		int flag,count=1,flag2=0;
		do {
			flag=0;
			if(flag2==0) {
				for(int i=S-1;i<N;i++) {
					if(n[i]==1) {
						flag=1;
						if(0==count++%M) {
							System.out.println(i+1);
							n[i]=0;
						}
					}
				}
				flag2=1;
			}else {
				for(int i=0;i<N;i++) {
					if(n[i]==1) {
						flag=1;
						if(0==count++%M) {
							System.out.println(i+1);
							n[i]=0;
						}
					}
				}
			}
		}while(1==flag);
	}
}
