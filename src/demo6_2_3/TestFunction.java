package demo6_2_3;

public abstract class TestFunction {
	
	//�κζ���
	public void testPublic() {
		System.out.println("testPublic");
	}
	
	//����
	private void testPrivate() {
		System.out.println("testPrivate");
	}
	
	//���ࡢ���ࡢͬ����
	protected void testProtected() {
		System.out.println("testProtected");
	}
	
	//���ࡢͬ����
	void testQueShen() {
		System.out.println("testQueShen");
	}
	
	//�˷������ܱ����า��
	public final void testFinal() {
		System.out.println("testFinal");
	}
	
	//��ʹ������.�ķ�ʽ���ô˷���,���贴������
	public static void testStatic() {
		System.out.println("testStatic");
	}
	
	//���󷽷�
	public abstract void testAbstract();
	
	//ͬ�������������ڶ��̻߳�����ȥ��������ͬ������
	public  synchronized void testSychronized() {
		System.out.println("testSychronized");
	}
	
	//�������η�
	public native void testNative();
	
}
