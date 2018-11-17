package demo7_InnerClass;
	
public class TestStaticInnerClass {
	
	private int out_publicVariable;
	private static int out_staticVariable;
	
	public void outClassFunction() {
		System.out.println("外部类普通方法被调用");
	}
	
	public static void outClassStaticFunction() {
		System.out.println("外部类静态方法被调用");
	}
	
	public void TestInnerClass() {
		StaticInnerCalss staticInnerCalss=new StaticInnerCalss();//静态内部类内部类的创建
		
		System.out.println(staticInnerCalss.in_publicVariable);
		System.out.println(staticInnerCalss.in_staticVariable);
		System.out.println(StaticInnerCalss.in_staticVariable);
	}
	
	//static innerClass
	public static class StaticInnerCalss{
		
		private int in_publicVariable;
		private static int in_staticVariable;
		
		public void InnerClassFunction() {
			System.out.println(out_staticVariable);
//			System.out.println(out_publicVariable);访问非静态类型的变量出错
			out_staticVariable+=1;
//			outClassFunction();访问外部类非静态方法失败
			outClassStaticFunction();//访问外部类静态方法
			}
	}
	
	public static void main(String[] args) {
		TestStaticInnerClass testStaticInnerClass=new TestStaticInnerClass();
		System.out.println(testStaticInnerClass.out_staticVariable);
		
		StaticInnerCalss staticInnerCalss=new StaticInnerCalss();
		staticInnerCalss.InnerClassFunction();
		System.out.println(testStaticInnerClass.out_staticVariable);
		StaticInnerCalss staticInnerCalss1=new StaticInnerCalss();
		staticInnerCalss1.InnerClassFunction();
		System.out.println(testStaticInnerClass.out_staticVariable);
	}
	
}
