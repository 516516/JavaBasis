package demo6_2_4;
	
public class TestStaticBianliang {
	
	//一、成员变量分类区分
	private int a=34;//普通成员变量
	private static double d =90.00;//类成员变量
	
	//二、普通成员方法区分
	//1、静态成员方法：不能使用静态的成员
	public static void testStaticFunction() {
		System.out.println("我是静态变量");
//		System.out.println(a);报错：尝试使用非静态成员变量
		System.out.println(d);//使用静态成员
//		testNotStaticFunction();报错：尝试使用非静态方法
		staticFunction();//调用静态方法
	}
	
	//2、非晶态成员方法：静态成员非静态成员都可以使用
	public void testNotStaticFunction() {
		System.out.println("我是非静态变量");
		System.out.println(a);//使用非静态成员变量
		System.out.println(d);//使用静态成员变量
		testStaticFunction();//调用静态方法
		notStaticFunction();//调用非静态方法
	}
	
	public void notStaticFunction() {
		System.out.println("我是非静态方法（非类方法）");
	}
	
	public static void staticFunction() {
		System.out.println("我是静态方法（非类方法）");
	}

	public static void main(String[] args) {
		TestStaticBianliang testStaticBianliang=new TestStaticBianliang();	
		//测试成员变量
		System.out.println("普通变量访问："+testStaticBianliang.a);
		System.out.println("类变量访问方式1："+testStaticBianliang.d);
		System.out.println("类变量访问方式2："+TestStaticBianliang.d);
	}
	
	//静态方法中不能使用this关键字。
/*	public static int getA() {
		return this.a;
	}*/
	
}
