package demo8_abstractClass_Interface;

abstract class Shape{
	protected String name;

	public Shape(String name) {
		super();
		this.name = name;
	}
	
	abstract public double getArea();
	abstract public double getLength();
	
}

class Cricle extends Shape{
	private static final double PI=3.14;
	private double radius;
	public Cricle(String name, double radius) {
		super(name);
		this.radius = radius;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return PI*radius*radius;
	}
	@Override
	public double getLength() {
		// TODO Auto-generated method stub
		return 2*PI*radius;
	}
	
}

class Rectangle extends Shape{
	private double length;
	private double height;
	public Rectangle(String name, double length, double height) {
		super(name);
		this.length = length;
		this.height = height;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return length*height;
	}
	@Override
	public double getLength() {
		// TODO Auto-generated method stub
		return 2*(length+height);
	}
	
}
public class TestAbstractClass {
	
	public static void main(String[] args) {
		Cricle cricle=new Cricle("Ô²", 2);
		System.out.println(cricle.getArea());
		System.out.println(cricle.getLength());
		Rectangle rectangle=new Rectangle("³¤·½ÐÎ", 12, 4);
		System.out.println(rectangle.getLength());
		System.out.println(rectangle.getArea());
	}
	
}
