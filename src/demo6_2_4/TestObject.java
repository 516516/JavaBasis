package demo6_2_4;
	
public class TestObject {
	
	private int a;
	
	public void  getA() {
		System.out.println(a);
	}
	
	public void setA(int a) {
		this.a = a;
	}
	
	public TestObject(int a) {
		super();
		this.a = a;
	}
	
	public void ComparyObject(TestObject testObject) {
		if(this==testObject) {
			System.out.println("�������");
		}else {
			System.out.println("�������");
		}
	}
	
	public static void main(String[] args) {
		
		TestObject obj1=new TestObject(10);
		TestObject obj2=new TestObject(10);
		
		//����ֵ������)
		TestObject obj3=obj1;
		
		//ָ��ͬһ�����������ö����ݵĸ��ָı����Դ˶���
		obj1.getA();
		obj3.setA(20);
		obj1.getA();
		
		//����ȽϷ���1
		obj1.ComparyObject(obj3);
		obj1.ComparyObject(obj2);
		
		//����ȽϷ���2
		System.out.println(obj1.equals(obj2));
		System.out.println(obj1.equals(obj3));
		
	}
}
