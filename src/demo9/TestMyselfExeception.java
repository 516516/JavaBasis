package demo9;


class TestMyselfExeception extends Exception {
	
	double radius;
	
	public TestMyselfExeception(double radius) {
		super();
		this.radius = radius;
	}
	
	@Override
	public String toString() {
		return "�뾶r="+radius+"����һ������";
	}
	
}

class Cricle{
	
	private double radius;
	
	public void setRadius(double r)throws TestMyselfExeception{
		if(r<0) {
			throw new TestMyselfExeception(r);
		}else {
			radius=r;
		}
	}
	
	public void show() {
		System.out.println("���Ϊ= "+3.14*radius*radius);
	}
	
	public static void main(String args[]) {
		Cricle cricle=new Cricle();
		try {
			cricle.setRadius(-2.0);
		} catch (TestMyselfExeception e) {
			System.out.println("�Զ����쳣"+e.toString());
		}
		cricle.show();
	}
	
}

