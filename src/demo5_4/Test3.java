package demo5_4;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		int Num[][]=new int[3][3];
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				Num[i][j]=scanner.nextInt();
			}
		}
		
		int sum=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(i==j) {
					sum+=Num[i][j];
				}
			}
		}
		
		System.out.println(sum);
		
	}

}
