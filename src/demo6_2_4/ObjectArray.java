package demo6_2_4;

public class ObjectArray {
	
	private int age;
	private String  name;
	
	public ObjectArray(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void show(){
		System.out.println("姓名："+name+"  "+"年龄："+age);
	}
	
	public static void main(String[] args) {
		
		ObjectArray per[]=new ObjectArray[3];
		
		per[0]=new ObjectArray(23,"张三");
		per[1]=new ObjectArray(12,"李四");
		per[2]=new ObjectArray(89,"王五");
		
		per[0].show();
		per[1].show();
		per[2].show();
		
	}
}
