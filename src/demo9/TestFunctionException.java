package demo9;

public class TestFunctionException {
	public static void main(String[] args) {
		int a=5,b=0;
		try {
			if(b==0) {
				throw new ArithmeticException();
			}else {
				System.out.println(a+"/"+b+"="+a/b);
			}
		}catch (ArithmeticException e) {
			System.out.println("�쳣��"+e+"���׳���");
			e.printStackTrace();
		}
	}
	
}
