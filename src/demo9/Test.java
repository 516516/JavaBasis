package demo9;

public class Test {

	public static void main(String[] args) {
		int a=6,b=0;
		try {
			System.out.println(a/b);
			System.out.println("���᷵��ִ�д˾��𣿣�������");
		} catch (ArithmeticException e) {
			System.out.println("����Ϊ0");
		}finally {
			System.out.println("�쳣�������");
		}
		System.out.println("trycatch�����");
	}
}
