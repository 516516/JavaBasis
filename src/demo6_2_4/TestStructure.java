package demo6_2_4;

public class TestStructure {
	
	
	private int intVariable;
	private byte byteVariable;
	private short shortVariable;
	private long longVariable;
	private double doubleVariable;
	private float floatVariable;
	private char charVariable;
	private boolean booleanVariable;
	
	
	//�޲ι��캯��
	//��û���вι��캯������ʱ��ϵͳĬ�ϸ�ÿ���ഴ��һ���޲ι��캯��
	public TestStructure() {
		//super();
		this(89);//����������໥����
	}
	
	
	//һ�������Ĺ��캯��
	public TestStructure(int intVariable) {
		super();
		this.intVariable = intVariable;
	}
	
	
	//˽�й��캯����ֻ�������ڲ����ܹ�����
	private TestStructure(int intVariable, byte byteVariable) {
		super();
		this.intVariable = intVariable;
		this.byteVariable = byteVariable;
	}
	
	
	//���ֲ������캯��
	public TestStructure(int intVariable, byte byteVariable, short shortVariable, long longVariable) {
		this(30);//����������໥����
		this.intVariable = intVariable;
		this.byteVariable = byteVariable;
		this.shortVariable = shortVariable;
		this.longVariable = longVariable;
	}
	
	
	//ȫ���������캯��
	public TestStructure(int intVariable, byte byteVariable, short shortVariable, long longVariable,
			double doubleVariable, float floatVariable, char charVariable, boolean booleanVariable) {
		super();
		this.intVariable = intVariable;
		this.byteVariable = byteVariable;
		this.shortVariable = shortVariable;
		this.longVariable = longVariable;
		this.doubleVariable = doubleVariable;
		this.floatVariable = floatVariable;
		this.charVariable = charVariable;
		this.booleanVariable = booleanVariable;
	}
	
	
	public static void main(String[] args) {
		TestStructure testStructure=new TestStructure();
	}
	
}
