package demo6_2_4;

public class TestFunctionDiaoyong {
	
	private int testvalue;
	TestFunctionDiaoyong testFunctionDiaoyong;
	
	public static void main(String[] args) {
		TestFunctionDiaoyong testFunctionDiaoyong=new TestFunctionDiaoyong();
		testFunctionDiaoyong.setObjectvalue(testFunctionDiaoyong);
		TestFunctionDiaoyong testFunctionDiaoyong2=testFunctionDiaoyong.getTestFunctionDiaoyong();
		System.out.println(testFunctionDiaoyong2.getTestvalue());
	}
	
	public int getTestvalue() {
		return testvalue;
	}
	
	public void setTestvalue(int testvalue) {//�Ի������ͱ���Ϊ�����ķ�������
		this.testvalue = testvalue;
	}
	
	public void setObjectvalue(TestFunctionDiaoyong testFunctionDiaoyong) {//����������Ϊ�����ķ�������
		this.testFunctionDiaoyong=testFunctionDiaoyong;
	}

	public TestFunctionDiaoyong getTestFunctionDiaoyong() {
		return testFunctionDiaoyong;
	}
	
}
