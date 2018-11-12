package demo6_2_2;

public class TestBianliang {
	
	//访问控制修饰符
	public int publict;//all
	private int privatet;//仅己类
	protected int protectedt;//己类、同一包、子类
	int queshengt;//己类、同一包
	
	//其他修饰符
	final int finalt=0;//必须申明时赋值，之不能改变
	static int statict;//所有实例共享
	transient int transientt;//系统保留、暂无特别作用的临时变量。
	volatile int volatilet;//同时被几个线程控制修改。
	
	public int getPublict() {
		return publict;
	}
	public void setPublict(int publict) {
		this.publict = publict;
	}
	public int getPrivatet() {
		return privatet;
	}
	public void setPrivatet(int privatet) {
		this.privatet = privatet;
	}
	public int getProtectedt() {
		return protectedt;
	}
	public void setProtectedt(int protectedt) {
		this.protectedt = protectedt;
	}
	public int getQueshengt() {
		return queshengt;
	}
	public void setQueshengt(int queshengt) {
		this.queshengt = queshengt;
	}
	public static int getStatict() {
		return statict;
	}
	public static void setStatict(int statict) {
		TestBianliang.statict = statict;
	}
	public int getTransientt() {
		return transientt;
	}
	public void setTransientt(int transientt) {
		this.transientt = transientt;
	}
	public int getVolatilet() {
		return volatilet;
	}
	public void setVolatilet(int volatilet) {
		this.volatilet = volatilet;
	}
	public int getFinalt() {
		return finalt;
	}
	
	public static void main(String args[]) {
		TestBianliang testBianliang=new TestBianliang();
		testBianliang.setStatict(10);
		TestBianliang testBianliang2=new TestBianliang();
		testBianliang2.setStatict(testBianliang.getStatict()+10);
		
		System.out.println(testBianliang2.getStatict());
		System.out.println(testBianliang.getStatict());
		
	}
	
}
