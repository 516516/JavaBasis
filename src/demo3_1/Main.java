package demo3_1;

public class Main {
	private static char chartest;
	public static String getType(Object m) {
		return m.getClass().toString();
    }
	public static void main(String[] args) {
//	            数据类型                                                                                                    字节数                   包装类                          默认值                       取值范围
		
		boolean boolean_=true;          //     1                      false        true/false
		byte byte_=3;                   //     1          Byte          0          -128~127
		short short_=3;                 //     2          Short         0          -32768~32767
		int int_=3;                     //     4          Integer       0          -2147483648~2147483647
		long long_=2147483648l;         //     8          Long          0L         -9223372036854775808~9223372036854775807
		float float_=34.0f;             //     4          Float         0.0F       负数：-3.4E+38~-1.4E-45    正数：1.4E-45~3.4E+38
		double double_=23E0;            //     8          Double        0.0D       负数：-1.7E+308~-4.9E-324    正数：4.9E-324~1.7E+308
		char char_='9';                 //     2                       'u\0000'    'u\0000'~'u\ffff'
		
		int inta=(int)'a';//97
		int intA=(int)'A';//65
		char chara=(char)97;//a
		char charA=(char)65;//A
		char char0=(char)20320;//你
		
//		boolean boolean=1;      int不能转化为boolean    	
//		short short__;
//		short__+=short_;        错误  局部变量声明后不赋赋值会出现编译错误 (堆内存与栈内存)		
//	    long long_=2147483648;  正确 long类型的变量赋值时不加L或l，超出int类型数据范围时报错，没有超出是不报错	
//		float float_=34.0;      错误 float类型变量赋值时不加f或F，直接报错，不加的话默认是double类型的数据类型		
//		double doubl=34E;       错误		
//		double doubl=34E0;      正确	
//		double doubl=34E0F;     正确	
//		Unicode字符编码              65536个字符     'u\0000'~'u\ffff'  
		
//		数据类型转换
		char charvalue='3';
//		byte char_byte=charvalue;     出错
//		short char_short=charvalue;   出错
		
		byte bytevlaue=12;
		short shortvalue=13;	

		int a=155,b=9;
		float g,h;
		g=a/b;
		h=(float)a/b;
		
		String string=""+1234;
		int inttet=Integer.parseInt(string);
		System.out.println(inttet);
		System.out.println(string);
		System.out.println(getType(inttet));
		
		String str="true";
		Boolean booleantet=Boolean.parseBoolean(str);
		System.out.println(booleantet);
		System.out.println(getType(booleantet));
		
	}

}
