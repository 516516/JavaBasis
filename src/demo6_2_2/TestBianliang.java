package demo6_2_2;

public class TestBianliang {
	
	//���ʿ������η�
	public int publict;//all
	private int privatet;//������
	protected int protectedt;//���ࡢͬһ��������
	int queshengt;//���ࡢͬһ��
	
	//�������η�
	final int finalt=0;//��������ʱ��ֵ��֮���ܸı�
	static int statict;//����ʵ������
	transient int transientt;//ϵͳ�����������ر����õ���ʱ������
	volatile int volatilet;//ͬʱ�������߳̿����޸ġ�
	
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
