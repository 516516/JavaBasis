package demo5_4;

import java.util.Scanner;

public class Test10 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String str1=scanner.next();
		char deletChar=scanner.next().charAt(0);
		System.out.println(str1);
		System.out.println(deletChar);
		System.out.println(deletStr(str1,deletChar));
		
	}
	public static String deletStr(String sourceStr,char c) {
		StringBuilder stringBuilder=new StringBuilder();
		for(int i=0;i<sourceStr.length();i++) {
			if(sourceStr.charAt(i)!=c) {
				 stringBuilder.append(sourceStr.charAt(i));
			}
		}
		return stringBuilder.toString();
	}

}
