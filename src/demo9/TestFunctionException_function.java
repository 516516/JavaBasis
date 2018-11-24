package demo9;

public class TestFunctionException_function {
	
	public static double muti(int n) {
		if(n<0) {
			throw new IllegalArgumentException("�����׳��쳣");
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
			System.out.println("��������û�в���");
		}catch (NumberFormatException e) {
			System.out.println("Ӧ������һ������");
		}catch (IllegalArgumentException e) {
			System.out.println("���ֵ��쳣��"+e.toString());
		}finally {
			System.out.println("�������н���");
		}
	}
	
}
