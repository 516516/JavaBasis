package demo4_2;
//三个数中的最大数，最小数
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int a,b,c,min,max;
		Scanner scanner=new Scanner(System.in);
		a=scanner.nextInt();
		b=scanner.nextInt();
		c=scanner.nextInt();
		if(a>b) {
			max=a;
			min=b;
		}else {
			max=b;
			min=a;
		}
		max=c>max?c:max;
		min=c<min?c:min;
		System.out.println("max:"+max);
		System.out.println("min:"+min);
	}
	
}
