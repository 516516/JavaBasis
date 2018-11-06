package demo4_2;

import java.util.Scanner;

public class Main9 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int m=scanner.nextInt();
		int n=1,sum=1;
		while(sum<m) {
			sum*=n;
			n++;
		}
		System.out.println(n-2);
		System.out.println(sum/(n-1));
	}

}
