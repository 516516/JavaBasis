package demo4_2;
//switch case�ṹ
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		
		Scanner  scanner=new Scanner(System.in);
		int a=scanner.nextInt();
		int b=scanner.nextInt();
		char c=scanner.next().charAt(0);
		int result;
		
		switch (c) {//���ַ�/��������
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
			System.out.println("�����ַ�����");
			break;
		}		
	}

}
