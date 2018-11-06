package demo4_2;
//Ñ­»·½á¹¹
import java.util.Scanner;

public class Mian7 {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		//1¡¢
		int n;
		do {
			n=scanner.nextInt();
		}while(n<=0);
		
		
		//2¡¢
		int i=1,sum=0;
		while(i<=n) {
			sum+=i++;
		}
		System.out.println(sum);
		
		
		//3¡¢
		int numsum=0;
		for(int j=0;j<=10;j++) {
			 numsum+=j;
		}
		System.out.println(numsum);
		
	}
}
