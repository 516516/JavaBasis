package demo7_InnerClass;
	
public class TestInner {
	
	public InnerClass getInnerClass(final String name) {
		return new InnerClass(){
			private String name1;
			@Override
			public void setName() {
				// TODO Auto-generated method stub
				name1="����"+name;
			}
			@Override       
			public String getName() {
				// TODO Auto-generated method stub
				return name1;
			}
		};//ǧ����ٷֺ�
	}
	
	public static void main(String[] args) {
		TestInner testInner=new TestInner();
		InnerClass innerClass=testInner.getInnerClass("����");
		innerClass.setName();
		System.out.println(innerClass.getName());
	}
	
}