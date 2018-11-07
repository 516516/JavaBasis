package demo5_4;

import java.util.Scanner;

public class Test8 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String str1=scanner.next();
		String str2=scanner.next();
		if(str1.equals(str2)) {
			System.out.println("相等");
		}else {
			System.out.println("不相等");
		}
	}
}
