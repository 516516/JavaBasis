package demo5_2;

import java.util.Scanner;

public class Test3 {
	public static void main(String args[]) {
		Scanner scanner=new Scanner(System.in);
		String string=scanner.nextLine();
		char char1=scanner.next().charAt(0);
		StringBuffer stringBuffer=new StringBuffer("");
		for(int i=0;i<string.length();i++) {
			if(char1!=string.charAt(i)) {
				stringBuffer.append(string.charAt(i));
			}
		}
		System.out.println(stringBuffer.toString());
	}
}
