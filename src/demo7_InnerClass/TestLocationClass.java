package demo7_InnerClass;
	
public class TestLocationClass {
	
	public String getFruit() {
		final String name="ƻ��";
		String string="";
		if(name.equals("ƻ��")) {
			class InnerClass{
				private String fruit;
				public void setFruit() {
					fruit="apple";
				}
			}
			InnerClass innerClass=new InnerClass();
			innerClass.setFruit();
			string=name+innerClass.fruit;
		}
		return string;
	}
	
	public static void main(String[] args) {
		TestLocationClass testLocationClass=new TestLocationClass();
		System.out.println(testLocationClass.getFruit());
	}
	
}
