package demo5_4;

import java.util.Scanner;

public class Test12 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String string=null;
		while((string=scanner.nextLine())!=null) {
			if(string.equals("exit")) {
				break;
			}else {
				System.out.println(string);
			}
		}
	}

}
