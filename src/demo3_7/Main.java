package demo3_7;

public class Main {

	public static void main(String[] args) {
		
//		���������
		int a=155,b=9;
		
		System.out.println(a/b);
		System.out.println(a%b);
		System.out.println((float)a/b);//6
		System.out.println((double)a/b);//16
		
		if(a==((a/b)*b+a%b)){
			System.out.println(1);
		}
		
		if(a%b==(a-(int)a/b*b)) {// %�ɶԸ��������в���
			System.out.println(1);			
		}
		
		float c=90.02322f,d=90.02322f;
		if(c%d==(c-(int)c/d*d)) {// %�ɶԸ��������в���
			System.out.println(1);			
		}
		System.out.println(c/d);//3.9130435  ����Ǹ�����
		System.out.println(c%d);//21.0      ���ǲ���21
		System.out.println(c==d);//true ��������ò�Ҫ�����Ƚ�
		
		int i=0;
		i=i++ + ++i;
		System.out.println(i);//0+2
		
		int j=0;
		j=++j+ j++ +j++ +j++;
		System.out.println(j);//1+1+2+3
		
		int k=0;
		k=k++ + k++ + k++ + ++k;
		System.out.println(k);//0+1+2+4
		
		int m=0;
		m=++m + ++m;
		System.out.println(m);//1+2
//		System.out.println(++(m+1));++ --������������ʽ ֻ�������ڵ�������
		
		System.out.println(0+'9');//0+48
		
		
		
//      �߼������
		System.out.println((2==3)^(2==3));//false ��� ͬ���ͬ��Ϊ
		
		int test=0;
		if((2==6 )&(test++==1)){
		}else {
			System.out.println(test);//1
		}
		
		int test1=0;
		if((2==6)&&(test1++==1)) {
		}else {
			System.out.println(test1);//0
		}
		int test2=0;
		if((6==6)|(test2++==1)) {
		}else {
			System.out.println(test2);//0
		}
		
		int test3=0;
		if((6==6)||(test3++==1)) {
		}else {
			System.out.println(test3);//0
		}
		
//		��λ�����
		System.out.println(~3);//-4
		System.out.println(3&4);//0
		System.out.println(3|4);//7
		System.out.println(3^2);//1
		System.out.println(3>>2);//0
		System.out.println(3<<2);//12
		System.out.println(3>>>2);//0
		System.out.println(128>>1);//64
		
		System.out.println("3:"+Integer.toBinaryString(3));
		System.out.println("3>>1:"+Integer.toBinaryString(3>>1));
		
		System.out.println("-3:"+Integer.toBinaryString(-3));
		System.out.println("-3>>1:"+Integer.toBinaryString(-3>>1));
		System.out.println("-3>>>1:"+Integer.toBinaryString(-3>>>1));
		
		System.out.println(-3>>1);//-2[�����Ĳ����Ǳ������������������ֵ�ķ���+1]
		System.out.println(-3>>>1);//2147483646
		
	}
	
}
