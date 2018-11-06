package demo4_2;
//sum=(-1)^(n-1)*(1/n!)
import java.util.Scanner;

public class Test2 {
	public static void main(String args[]) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		double sum=0,sum1=1;
		for(int i=1;i<=n;i++) {
			sum1*=i;
			if(0==i%2) {
				sum-=1/sum1;
			}else {
				sum+=1/sum1;
			}
		}		
		System.out.println(sum);
	}
}
