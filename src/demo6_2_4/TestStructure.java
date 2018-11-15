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
	
	
	//无参构造函数
	//在没有有参构造函数存在时，系统默认给每个类创建一个无参构造函数
	public TestStructure() {
		//super();
		this(89);//构造参数间相互调用
	}
	
	
	//一个参数的构造函数
	public TestStructure(int intVariable) {
		super();
		this.intVariable = intVariable;
	}
	
	
	//私有构造函数，只有在类内部才能够调用
	private TestStructure(int intVariable, byte byteVariable) {
		super();
		this.intVariable = intVariable;
		this.byteVariable = byteVariable;
	}
	
	
	//部分参数构造函数
	public TestStructure(int intVariable, byte byteVariable, short shortVariable, long longVariable) {
		this(30);//构造参数间相互调用
		this.intVariable = intVariable;
		this.byteVariable = byteVariable;
		this.shortVariable = shortVariable;
		this.longVariable = longVariable;
	}
	
	
	//全部参数构造函数
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
