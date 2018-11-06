package demo5_1;
//10个数中的最大值
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		int array[]=new int[10];
		Scanner scanner=new Scanner(System.in);
		for(int i=0;i<array.length;i++) {
			array[i]=scanner.nextInt();
		}
		int max=array[0],min=array[0];
		for(int i=0;i<array.length;i++) {
			if(max<array[i]) {
				max=array[i];
			}
			if(min>array[i]) {
				min=array[i];
			}
		}
		System.out.println("min:"+min);
		System.out.println("max:"+max);
	}

}
