package demo6_2_4;
	
public class TestStaticBianliang {
	
	//һ����Ա������������
	private int a=34;//��ͨ��Ա����
	private static double d =90.00;//���Ա����
	
	//������ͨ��Ա��������
	//1����̬��Ա����������ʹ�þ�̬�ĳ�Ա
	public static void testStaticFunction() {
		System.out.println("���Ǿ�̬����");
//		System.out.println(a);��������ʹ�÷Ǿ�̬��Ա����
		System.out.println(d);//ʹ�þ�̬��Ա
//		testNotStaticFunction();��������ʹ�÷Ǿ�̬����
		staticFunction();//���þ�̬����
	}
	
	//2���Ǿ�̬��Ա��������̬��Ա�Ǿ�̬��Ա������ʹ��
	public void testNotStaticFunction() {
		System.out.println("���ǷǾ�̬����");
		System.out.println(a);//ʹ�÷Ǿ�̬��Ա����
		System.out.println(d);//ʹ�þ�̬��Ա����
		testStaticFunction();//���þ�̬����
		notStaticFunction();//���÷Ǿ�̬����
	}
	
	public void notStaticFunction() {
		System.out.println("���ǷǾ�̬���������෽����");
	}
	
	public static void staticFunction() {
		System.out.println("���Ǿ�̬���������෽����");
	}

	public static void main(String[] args) {
		TestStaticBianliang testStaticBianliang=new TestStaticBianliang();	
		//���Գ�Ա����
		System.out.println("��ͨ�������ʣ�"+testStaticBianliang.a);
		System.out.println("��������ʷ�ʽ1��"+testStaticBianliang.d);
		System.out.println("��������ʷ�ʽ2��"+TestStaticBianliang.d);
	}
	
	//��̬�����в���ʹ��this�ؼ��֡�
/*	public static int getA() {
		return this.a;
	}*/
	
}
