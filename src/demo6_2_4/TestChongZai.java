package demo6_2_4;

public class TestChongZai {
	
	public void testChongZai() {
		System.out.println("testChongZai无参");
	}

	public void testChongZai(int a) {
		System.out.println("testChongZai无参");
	}
	public void testChongZai(int a,int b) {
		System.out.println("testChongZai 两个参数"+a+"   "+b);
	}
	public void testChongZai(int a,int b,int c) {
		System.out.println("testChongZai 三个参数"+b+"    "+c);
	}
	public void testChongZai(int a,int b,int c,int d) {
		System.out.println("testChongZai 四个参数"+a+"   "+b+"   "+c+"   "+d);
	}
	
	public static void main(String[] args) {
		TestChongZai testChongZai=new TestChongZai();
		testChongZai.testChongZai();
		testChongZai.testChongZai(10);
		testChongZai.testChongZai(10, 20);
		testChongZai.testChongZai(100, 200, 3400);
		testChongZai.testChongZai(100, 2000, 400, 700);
	}
}
