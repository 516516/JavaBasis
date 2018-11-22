package demo8_abstractClass_Interface;

//父类
class Person{
	
	protected String name;
	protected int age;
	
	public Person() {
		System.out.println("父类的无参构造函数");
	}
	
	public Person(int age,String name) {
		super();
		System.out.println("父类的有参构造函数");
		this.name = name;
		this.age = age;
	}
	
	protected void show() {
		System.out.println("姓名："+name+" "+"年龄："+age);
	}
	
}

//子类
class Student extends Person{
	
	private String department;
	
	public Student() {
		super();
		System.out.println("子类无参构造函数被调用");
	}
	
	public Student(String department) {
		super();
		this.department = department;
	}

	public Student(int age,String name) {
		super.age=age;//子类调用父类成员变量
		super.name=name;
	}
	
	protected void show() {
		System.out.println("部门"+department);
	}
	
	protected void subShow() {
		System.out.println("部门"+department);
	}
	
}

//主类：测试类
public class TestExtends {
	
	public static void main(String args[]) {
		Person per=new Student(23,"计算机");
		Student student=(Student)per;
		student.show();
	}
	
}