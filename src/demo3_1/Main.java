package demo3_1;

public class Main {
	private static char chartest;
	public static String getType(Object m) {
		return m.getClass().toString();
    }
	public static void main(String[] args) {
//	            ��������                                                                                                    �ֽ���                   ��װ��                          Ĭ��ֵ                       ȡֵ��Χ
		
		boolean boolean_=true;          //     1                      false        true/false
		byte byte_=3;                   //     1          Byte          0          -128~127
		short short_=3;                 //     2          Short         0          -32768~32767
		int int_=3;                     //     4          Integer       0          -2147483648~2147483647
		long long_=2147483648l;         //     8          Long          0L         -9223372036854775808~9223372036854775807
		float float_=34.0f;             //     4          Float         0.0F       ������-3.4E+38~-1.4E-45    ������1.4E-45~3.4E+38
		double double_=23E0;            //     8          Double        0.0D       ������-1.7E+308~-4.9E-324    ������4.9E-324~1.7E+308
		char char_='9';                 //     2                       'u\0000'    'u\0000'~'u\ffff'
		
		int inta=(int)'a';//97
		int intA=(int)'A';//65
		char chara=(char)97;//a
		char charA=(char)65;//A
		char char0=(char)20320;//��
		
//		boolean boolean=1;      int����ת��Ϊboolean    	
//		short short__;
//		short__+=short_;        ����  �ֲ����������󲻸���ֵ����ֱ������ (���ڴ���ջ�ڴ�)		
//	    long long_=2147483648;  ��ȷ long���͵ı�����ֵʱ����L��l������int�������ݷ�Χʱ����û�г����ǲ�����	
//		float float_=34.0;      ���� float���ͱ�����ֵʱ����f��F��ֱ�ӱ������ӵĻ�Ĭ����double���͵���������		
//		double doubl=34E;       ����		
//		double doubl=34E0;      ��ȷ	
//		double doubl=34E0F;     ��ȷ	
//		Unicode�ַ�����              65536���ַ�     'u\0000'~'u\ffff'  
		
//		��������ת��
		char charvalue='3';
//		byte char_byte=charvalue;     ����
//		short char_short=charvalue;   ����
		
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
