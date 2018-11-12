package demo6_2_3;

public abstract class TestFunction {
	
	//任何对象
	public void testPublic() {
		System.out.println("testPublic");
	}
	
	//己类
	private void testPrivate() {
		System.out.println("testPrivate");
	}
	
	//己类、子类、同包类
	protected void testProtected() {
		System.out.println("testProtected");
	}
	
	//己类、同包类
	void testQueShen() {
		System.out.println("testQueShen");
	}
	
	//此方法不能被子类覆盖
	public final void testFinal() {
		System.out.println("testFinal");
	}
	
	//可使用类名.的方式调用此方法,无需创建对象
	public static void testStatic() {
		System.out.println("testStatic");
	}
	
	//抽象方法
	public abstract void testAbstract();
	
	//同步方法、用于在多线程环境下去出控制土同步问题
	public  synchronized void testSychronized() {
		System.out.println("testSychronized");
	}
	
	//本地修饰符
	public native void testNative();
	
}
