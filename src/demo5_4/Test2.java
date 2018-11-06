package demo5_4;

import java.util.Scanner;

public class Test2 {
	public static void main(String args[]) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int min=0,max=0,scanIn;
		for(int i=0;i<n;i++) {
			scanIn=scanner.nextInt();
			if(0==i) {
				min=scanIn;
				max=scanIn;
			}
			if(scanIn>max) {
				max=scanIn;
			}
			if(scanIn<min) {
				min=scanIn;
			}
		}
		System.out.println("min:"+min);
		System.out.println("max:"+max);
	}
}
