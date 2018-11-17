package demo7_InnerClass;
	
public class TestInner {
	
	public InnerClass getInnerClass(final String name) {
		return new InnerClass(){
			private String name1;
			@Override
			public void setName() {
				// TODO Auto-generated method stub
				name1="姓名"+name;
			}
			@Override       
			public String getName() {
				// TODO Auto-generated method stub
				return name1;
			}
		};//千万别少分号
	}
	
	public static void main(String[] args) {
		TestInner testInner=new TestInner();
		InnerClass innerClass=testInner.getInnerClass("张三");
		innerClass.setName();
		System.out.println(innerClass.getName());
	}
	
}