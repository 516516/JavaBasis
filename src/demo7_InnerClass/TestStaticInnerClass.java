package demo7_InnerClass;
	
public class TestStaticInnerClass {
	
	private int out_publicVariable;
	private static int out_staticVariable;
	
	public void outClassFunction() {
		System.out.println("�ⲿ����ͨ����������");
	}
	
	public static void outClassStaticFunction() {
		System.out.println("�ⲿ�ྲ̬����������");
	}
	
	public void TestInnerClass() {
		StaticInnerCalss staticInnerCalss=new StaticInnerCalss();//��̬�ڲ����ڲ���Ĵ���
		
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
//			System.out.println(out_publicVariable);���ʷǾ�̬���͵ı�������
			out_staticVariable+=1;
//			outClassFunction();�����ⲿ��Ǿ�̬����ʧ��
			outClassStaticFunction();//�����ⲿ�ྲ̬����
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
