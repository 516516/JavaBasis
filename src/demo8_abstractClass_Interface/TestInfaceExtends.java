package demo8_abstractClass_Interface;

interface Face1{
	double PI=3.14;
}
interface Face2{
	void getArea();
}
interface Face3 extends Face2,Face1{
	void getLength();
}

class TestInfaceExtends implements Face3{
	private String name;
	private double radius;
	
	public TestInfaceExtends(String name, double radius) {
		super();
		this.name = name;
		this.radius = radius;
	}
	

	@Override
	public void getLength() {
		// TODO Auto-generated method stub
		System.out.println(2*PI*radius);
	}

	@Override
	public void getArea() {
		// TODO Auto-generated method stub
		System.out.println(PI*radius*radius);
	}

}

class Test1{
	public static void main(String[] args) {
		TestInfaceExtends testInfaceExtends=new TestInfaceExtends("Բ", 3);
		testInfaceExtends.getArea();
		testInfaceExtends.getLength();
	}
}
