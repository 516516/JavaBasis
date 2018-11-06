package demo5_4;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int arrayNum[]=new int[n];
		for(int i=0;i<n;i++) {
			arrayNum[i]=scanner.nextInt();
		}
		
		int sum=0;
		for(int i=0;i<n;i++) {
			sum+=arrayNum[i];
		}
		
		double average=(double)sum/n;
		for(int i=0;i<n;i++) {
			if(arrayNum[i]>average) {
				System.out.println(arrayNum[i]);
			}
		}
		
	}

}
