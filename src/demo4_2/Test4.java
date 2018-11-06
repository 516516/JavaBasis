package demo4_2;
//完全数
import java.util.Scanner;

public class Test4 {
	public static  void main(String args[]) {
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		int sum=1;
		System.out.print(sum+" ");
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(0==num%i) {
				sum+=i;
				sum+=num/i;
				System.out.print(i+"  "+num/i+" ");
			}
		}
		if(sum==num) {
			System.out.println("是完全数");
		}
	}
}
