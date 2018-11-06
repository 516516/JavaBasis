package demo5_2;

import java.util.Scanner;

public class Test2 {
	public static void main(String arg[]) {
		Scanner scanner=new Scanner(System.in);
		String string=scanner.nextLine();
		int strlengthfirst=string.length();
		String string2=string.trim();//过滤tab键、空格键
		int strlengthlast=string2.length();
		System.out.println("trim()前："+strlengthfirst);
		System.out.println("trim()后："+strlengthlast);
		scanner.close();
		
		String string3="a";
		String string4="b";
		System.out.println(string3.compareTo(string4));
		System.out.println(string3.equals(string4));
		
		String string5="abcdefghigk";
		char chars[]=string5.toCharArray(); 
		
		char char1[]= {'w','e','t','y'};
		String string6=String.valueOf(char1);//方法1
		String string7=new String(char1);//方法2
		System.out.println(string6);
		System.out.println(string7);
		
	}
}
