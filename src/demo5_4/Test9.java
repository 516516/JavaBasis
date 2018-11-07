package demo5_4;

import java.util.Scanner;

public class Test9 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String str1=scanner.next();
		int first=scanner.nextInt();
		int length=scanner.nextInt();
		String str2=str1.substring(first, first+length);
		System.out.println(str1);
		System.out.println(str2);
	}

}
