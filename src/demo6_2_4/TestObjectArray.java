package demo6_2_4;

public class TestObjectArray {
	
	private int age;
	
	public TestObjectArray(int age) {
		super();
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public static int getMinAge(TestObjectArray obj[]) {
		int min=Integer.MAX_VALUE;
		for(int i=0;i<obj.length;i++) {
			if(min>obj[i].getAge()) {
				min=obj[i].getAge();
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		TestObjectArray objectArray[]=new TestObjectArray[3];
		objectArray[0]=new TestObjectArray(12);
		objectArray[1]=new TestObjectArray(234);
		objectArray[2]=new TestObjectArray(10);
		
		System.out.println(TestObjectArray.getMinAge(objectArray));
	}
}
