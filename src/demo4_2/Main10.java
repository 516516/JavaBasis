package demo4_2;

import java.util.Scanner;

public class Main10 {
	public static void main(String arg[]) {
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		boolean shusu=suNum( num);
		System.out.println(shusu);
	}
	public static boolean suNum(int num) {
		int j=3;
		if(num==2) {
			return true;
		}
		while(num%j!=0&&j<Math.sqrt(num)) {
			j++;
		}
		if(j>Math.sqrt(num)) {
			return true;
		}
		return false;
	}
}
