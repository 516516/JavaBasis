package demo4_2;
//sum=1!+2!+3!+.....+n!
import java.util.Scanner;

public class Test1 {
	public static void main(String args[]) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int sum=1,sum1=0;
		for(int i=1;i<=n;i++) {
			sum*=i;
			sum1+=sum;
		}
		System.out.println(sum1);
	}
}
