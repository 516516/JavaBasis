package demo9;

public class TestExeception {

	public static void main(String[] args) {
		int num[]= {1,2,3,4};
		for(int i=0;i<1;i++) {
			try {
				System.out.println("5/0:"+5/0);
				System.out.print("此句执行："+num[i]);
			}
			catch (ArithmeticException e) {
				System.out.println("除数为0");
				return ;
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("下标越界");
			}finally {
				System.out.println("finally");
			}
		}
		
	}
}