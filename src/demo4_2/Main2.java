package demo4_2;
//switch case结构
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		
		Scanner  scanner=new Scanner(System.in);
		int a=scanner.nextInt();
		int b=scanner.nextInt();
		char c=scanner.next().charAt(0);
		int result;
		
		switch (c) {//仅字符/整数类型
		case '+':
			result=a+b;
			System.out.println(result);
			break;
		case '-':
			result=a-b;
			System.out.println(result);
			break;
		case '*':
			result=a*b;
			System.out.println(result);
			break;
		case '/':
			result=a/b;
			System.out.println(result);
			break;
		default:
			System.out.println("输入字符有误");
			break;
		}		
	}

}
