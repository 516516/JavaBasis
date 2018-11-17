package demo7_InnerClass;

public class TestOutClassInnerClass {
	
	private int outVariable;
	
	//外部类方法访问内部类成员
	public void getOutVariable() {
		System.out.println("外部类方法"+" "+"外部内变量值："+outVariable);
		InnerClass innerClass=new InnerClass();
		innerClass.innerVariable+=10;
		System.out.println("外部类方法调用内部类"+" "+"内部类变量值："+innerClass.innerVariable);
	}
	
	//内部类
	public  class InnerClass{
//		static int a=10;
		private int innerVariable;
		public void getInnerVariable() {
			System.out.println("内部类方法");
		}
		public void getOutVariableAndFunction() {
			System.out.println("使用外部类成员变量"+" "+outVariable);
			outVariable+=10;
			System.out.println("使用外部类成员变量结束"+" "+outVariable);
			getOutVariable();
		}
	}
	
	public InnerClass getInnerClass() {
		return new InnerClass();
	}
	
	public static void main(String[] args) {
		TestOutClassInnerClass testOutClassInnerClass=new TestOutClassInnerClass();
		TestOutClassInnerClass.InnerClass innerClass=testOutClassInnerClass.getInnerClass(); 
		TestOutClassInnerClass.InnerClass innerClass2=testOutClassInnerClass.new InnerClass();
		
		innerClass.getOutVariableAndFunction();
		innerClass2.getOutVariableAndFunction();
		
		TestOutClassInnerClass testOutClassInnerClass1=new TestOutClassInnerClass();
		TestOutClassInnerClass.InnerClass innerClass3=testOutClassInnerClass1.getInnerClass(); 
		TestOutClassInnerClass.InnerClass innerClass4=testOutClassInnerClass1.new InnerClass();
		
		innerClass3.getOutVariableAndFunction();
		innerClass4.getOutVariableAndFunction();
	}
}
