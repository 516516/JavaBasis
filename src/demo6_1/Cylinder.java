package demo6_1;

public class Cylinder{
	
	private double radius;
	int height;
	double pi=3.14;
	
	void area() {
		System.out.println("�����="+pi*radius*radius);
	}
	
	void volume() {
		System.out.println("�����="+pi*radius*radius*height);
	}
	
	public static void main(String args[]) {
		Cylinder volu=new Cylinder();
		volu.area();
		volu.volume();
	}
	
}
