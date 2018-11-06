package demo4_2;
//各位数相加
import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		int sum=0;
		while(0!=num/10) {
			sum+=num%10;
			num=num/10;
		}
		sum+=num;
		System.out.println(sum);
	}

}
