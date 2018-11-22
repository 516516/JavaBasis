package demo8_abstractClass_Interface;
	
class Person1{
	
	static final double PI=3.14;
	final int a;
	
	public Person1(int a) {
		super();
		this.a = a;
	}
	
	public final void show() {
		System.out.println("父类中的方法");
	}
	
}
class Student1 extends Person1{
	
	private int num=100;
	
	public Student1(int a) {
		super(a);
	}
	
}

public class TestFinalAndMain {
	
	public static void main(String[] args) {
		Student1 student1=new Student1(10);
		student1.show();
	}
	
}