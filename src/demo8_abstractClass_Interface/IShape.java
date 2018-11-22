package demo8_abstractClass_Interface;

interface IShape{
	final double PI=3.14;
	public abstract double getArea();
	public abstract double getLength();
}

class Cricle2 implements IShape{
	
	private double radius;
	private String name;

	public Cricle2(double radius, String name) {
		super();
		this.radius = radius;
		this.name = name;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return PI*PI*radius;
	}
	
	@Override
	public double getLength() {
		// TODO Auto-generated method stub
		return 2*PI*radius;
	}
	
}

class Regctangle2 implements IShape{
	
	private double height;
	private double length;
	
	public Regctangle2(double height, double length) {
		super();
		this.height = height;
		this.length = length;
	}

	@Override
	public double getArea() {
		return 2*height*length;
	}

	@Override
	public double getLength() {
		return 2*(height+length);
	}
	
}

class Test{
	public static void main(String args[]) {
		Cricle2 cricle2=new Cricle2(12, "Բ");
		System.out.println(cricle2.getArea());
		System.out.println(cricle2.getLength());
		Regctangle2 regctangle2=new Regctangle2(78, 2);
		System.out.println(regctangle2.getLength());
		System.out.println(regctangle2.getArea());
		
		
	}
}