package demo7_InnerClass;

public class TestOutClassInnerClass {
	
	private int outVariable;
	
	//�ⲿ�෽�������ڲ����Ա
	public void getOutVariable() {
		System.out.println("�ⲿ�෽��"+" "+"�ⲿ�ڱ���ֵ��"+outVariable);
		InnerClass innerClass=new InnerClass();
		innerClass.innerVariable+=10;
		System.out.println("�ⲿ�෽�������ڲ���"+" "+"�ڲ������ֵ��"+innerClass.innerVariable);
	}
	
	//�ڲ���
	public  class InnerClass{
//		static int a=10;
		private int innerVariable;
		public void getInnerVariable() {
			System.out.println("�ڲ��෽��");
		}
		public void getOutVariableAndFunction() {
			System.out.println("ʹ���ⲿ���Ա����"+" "+outVariable);
			outVariable+=10;
			System.out.println("ʹ���ⲿ���Ա��������"+" "+outVariable);
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
