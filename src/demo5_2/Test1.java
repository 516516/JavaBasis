package demo5_2;

import java.util.Scanner;

public class Test1 {
	public static void main(String args[]) {
		Scanner scanner=new Scanner(System.in);
		String string=scanner.nextLine();
		int strLength=string.length();
		int flag=0;
		for(int i=0;i<strLength/2;i++) {
			char charfirst=string.charAt(i);
			char charlast=string.charAt(strLength-i-1);
			System.out.print(charfirst+"  ");
			System.out.println(charlast);
			if(charfirst!=charlast) {
				flag=1;
				break;
			}
		}
		if(flag==1) {
			System.out.println("不是回文");
		}else {
			System.out.println("是回文");
		}
	}
}
