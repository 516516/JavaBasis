package demo6_2_4;
	
public class Person {
	
	private int age;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Person(int age) {
		super();
		this.age = age;
	}
	
	public Person getAgePull(Person person) {
		if(this.age>person.age) {
			return this;
		}else {
			return  person;
		}
	}
	
	public static void main(String[] args) {
		Person person=new Person(10);
		Person person2=new Person(20);
		Person person3=person.getAgePull(person2);
		System.out.println(person3.getAge());
	}
	
}
