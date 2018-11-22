package demo8_abstractClass_Interface;
	
class TestObject{
	
	private int age;
	
	@Override
	public String toString() {
		return "TestObject [age=" + age + "]";
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("垃圾回收前执行的函数");
	}
	
}

public class TestObjectClass {
	
	public static void main(String[] args) {
		
		Object object=new Object();
		TestObject testObject=new TestObject();
		TestObject testObject1=new TestObject();
		TestObject testObject2=testObject;
		TestObject testObject3=testObject;

		Class obj=testObject.getClass();
		System.out.println(obj.getName());
		System.out.println(obj.getSuperclass());
		System.out.println(obj.isInterface());
		
		System.out.println(testObject.getClass().getName());//取得本类名
		System.out.println(testObject.getClass().getSuperclass().getName());//取得父类
		
		System.out.println(testObject.hashCode());
		System.out.println(testObject1.hashCode());
		System.out.println(testObject2.hashCode());
		
		System.out.println(testObject.equals(object));
		System.out.println(object.toString());
		System.out.println(testObject.toString());
		
		try {
			testObject3.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}