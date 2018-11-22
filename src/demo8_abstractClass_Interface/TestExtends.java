package demo8_abstractClass_Interface;

//����
class Person{
	
	protected String name;
	protected int age;
	
	public Person() {
		System.out.println("������޲ι��캯��");
	}
	
	public Person(int age,String name) {
		super();
		System.out.println("������вι��캯��");
		this.name = name;
		this.age = age;
	}
	
	protected void show() {
		System.out.println("������"+name+" "+"���䣺"+age);
	}
	
}

//����
class Student extends Person{
	
	private String department;
	
	public Student() {
		super();
		System.out.println("�����޲ι��캯��������");
	}
	
	public Student(String department) {
		super();
		this.department = department;
	}

	public Student(int age,String name) {
		super.age=age;//������ø����Ա����
		super.name=name;
	}
	
	protected void show() {
		System.out.println("����"+department);
	}
	
	protected void subShow() {
		System.out.println("����"+department);
	}
	
}

//���ࣺ������
public class TestExtends {
	
	public static void main(String args[]) {
		Person per=new Student(23,"�����");
		Student student=(Student)per;
		student.show();
	}
	
}