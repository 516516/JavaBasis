package demo9;

public class Test {

	public static void main(String[] args) {
		int a=6,b=0;
		try {
			System.out.println(a/b);
			System.out.println("还会返回执行此句吗？？？？？");
		} catch (ArithmeticException e) {
			System.out.println("除数为0");
		}finally {
			System.out.println("异常捕获结束");
		}
		System.out.println("trycatch外句子");
	}
}
