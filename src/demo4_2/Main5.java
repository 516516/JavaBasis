package demo4_2;

import java.util.Scanner;

public class Main5 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int input=scanner.nextInt();
		int c=0,a=0,b=1;
		while(c<input) {
			c=a+b;
			a=b;
			b=c;
		}
		if(c==input) {
			System.out.println("ÊÇ");
		}else {
			System.out.println("·ñ");
		}
	}
}
