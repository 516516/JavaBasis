package demo4_2;

import java.util.Scanner;

public class Main8 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int a=scanner.nextInt();
		int b=scanner.nextInt();
		int k;
		do {
			k=a%b;
			a=b;
			b=k;
		}while(k!=0);
		System.out.println(a);
	}

}
