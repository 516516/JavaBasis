package demo4_2;

import java.util.Scanner;

public class Main6 {

	public static void main(String[] args) {
		double sum=0;
		Scanner scanner=new Scanner(System.in);
		
//		接收double类型的一串数据，当输入的数据不是double类型时停止
/*		while(scanner.hasNextDouble()) {
			double x=scanner.nextDouble();
			sum+=x;
		}
		System.out.println(sum);*/
		
//		接收w字符的所有int类型的数据
/*		int sumint=0;
		while(!scanner.hasNext("w")) {
			 int intvalue=scanner.nextInt();
			 sumint+=intvalue;
		}
		System.out.println(sumint);*/
		
//		输入单个字符
/*		char onechar=scanner.next().charAt(0);//next略去有效字符前的空格、tab、回车；输入有效字符后，遇到空格、tab、回车键结束。
		System.out.println(onechar);*/
		
/*		String str=scanner.nextLine();//nextLine接受所有字符，遇到回车键结束。
		System.out.println(str);*/
		
	}
}
