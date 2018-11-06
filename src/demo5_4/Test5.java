package demo5_4;

import java.util.Random;
	
public class Test5 {
	
	public static void main(String[] args) {
		
		Random random=new Random();
		int testnum2=random.nextInt(100);
		
		int Num[]=new int[8];
		for(int i=0;i<8;i++) {
			Num[i]=random.nextInt(100);
		}
		
		for(int i=0;i<8;i++) {
			System.out.print(Num[i]+" ");
		}
		
/*		for(int i=0;i<8-1;i++) {
			for(int j=i+1;j<8;j++) {
				if(Num[i]>Num[j]) {
					int change=Num[i];
					Num[i]=Num[j];
					Num[j]=change;
				}
			}
		}*/
		
		for(int i=0;i<8;i++) {
			for(int j=0;j<8-i-1;j++) {
				if(Num[j]>Num[j+1]) {
					int change=Num[j];
					Num[j]=Num[j+1];
					Num[j+1]=change;
				}
			}
		}
		
		System.out.println();
		for(int i=0;i<8;i++) {
			System.out.print(Num[i]+" ");
		}
		
	}
}	
