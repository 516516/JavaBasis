package demo3_6;

import java.util.Scanner;

public class Stream_in_out {
	public static void main(String args[]) {
		Scanner scanner=new Scanner(System.in);
		
		boolean boo=scanner.nextBoolean();
		System.out.println(boo);
		
		byte bytevalue=scanner.nextByte();
		System.out.println(bytevalue);
		
		short shortvalue=scanner.nextShort();
		System.out.println(shortvalue);
		
		int intvalue=scanner.nextInt();
		System.out.println(intvalue);
		
		long longvalue=scanner.nextLong();
		System.out.println(longvalue);
		
		float floatvalue=scanner.nextFloat();
		System.out.println(floatvalue);
		
		double doublevalue=scanner.nextDouble();
		System.out.println(doublevalue);
		
		String  str1=scanner.nextLine();//���ܻس���ǰ�������ַ�
		System.out.println("str1:"+str1);
		
		String  str2=scanner.next();//��ȥ��Ч�ַ�ǰ�Ŀո񡢻س���tab�������ո񡢻س���tab��������
		System.out.println("str2:"+str2);
		
		char charvalue=scanner.next().charAt(0);//���뵥���ַ�
		System.out.println("char:"+charvalue);
	}
}
