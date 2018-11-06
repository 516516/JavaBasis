package demo5_4;

import java.util.Scanner;

public class Test4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int Num[][]=new int[4][5];
		Scanner scanner=new Scanner(System.in);
		for(int i=0;i<4;i++) {
			for(int j=0;j<5;j++) {
				Num[i][j]=scanner.nextInt();
			}
		}
		int max=Num[0][0],maxi=0,maxj=0;
		int min=Num[0][0],mini=0,minj=0;
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<5;j++) {
				if(Num[i][j]>max) {
					max=Num[i][j];
					maxi=i;
					maxj=j;
				}
				if(Num[i][j]<min) {
					min=Num[i][j];
					mini=i;
					minj=j;
				}
				
			}
		}
		System.out.print("min:"+min+" "+mini+" "+minj);
		System.out.print("max:"+max+" "+maxi+" "+maxj);
	}

}
