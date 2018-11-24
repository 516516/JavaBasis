package demo9;

public class TestFunctionException_function {
	
	public static double muti(int n) {
		if(n<0) {
			throw new IllegalArgumentException("求负数阶乘异常");
		}
		double s=1;
		for(int i=1;i<=n;i++) {
			s=s*i;
		}
		return s;
	}
	
	public static void main(String args[]) {
		try {
			int m=Integer.parseInt("1.00");
			System.out.println(m+"!="+muti(m));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("命令行中没有参数");
		}catch (NumberFormatException e) {
			System.out.println("应该输入一个整数");
		}catch (IllegalArgumentException e) {
			System.out.println("出现的异常是"+e.toString());
		}finally {
			System.out.println("程序运行结束");
		}
	}
	
}
