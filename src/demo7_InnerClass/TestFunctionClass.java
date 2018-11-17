package demo7_InnerClass;
	
public class TestFunctionClass {
	
	public String  testFunctionClass(){
		final String name="方法内的局部内部类";
		int m=200;
		class Inner{
			private int data;
			public String  function() {
				data=10+m;
				return name+data;
			}
		}
		Inner inner=new Inner();
		return name+inner.function();
	}
	
	public static void main(String[] args) {
		TestFunctionClass testFunctionClass=new TestFunctionClass();
		System.out.println(testFunctionClass.testFunctionClass());
	}
	
}