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
			System.out.println("对象相等");
		}else {
			System.out.println("对象不相等");
		}
	}
	
	public static void main(String[] args) {
		
		TestObject obj1=new TestObject(10);
		TestObject obj2=new TestObject(10);
		
		//对象赋值（拷贝)
		TestObject obj3=obj1;
		
		//指向同一对象，两个引用对数据的各种改变均针对此对象
		obj1.getA();
		obj3.setA(20);
		obj1.getA();
		
		//对象比较方法1
		obj1.ComparyObject(obj3);
		obj1.ComparyObject(obj2);
		
		//对象比较方法2
		System.out.println(obj1.equals(obj2));
		System.out.println(obj1.equals(obj3));
		
	}
}
