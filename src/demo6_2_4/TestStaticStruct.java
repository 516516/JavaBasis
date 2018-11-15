package demo6_2_4;

public class TestStaticStruct {
	private static int intvariable;
	static {
		intvariable=10;
	}
	static {
		intvariable=2;
	}
	public static void main(String[] args) {
		TestStaticStruct testStaticStruct=new TestStaticStruct();
		System.out.println(testStaticStruct.intvariable);
	}
}






