package demo3_7;

public class Main4 {

	public static void main(String[] args) {
		
		//1��
		int j=0;
		for(int i=0;i<100;i++) {
			j=j++;
		}
		System.out.println(j);
		//temp=j;
		//j=j+1;
		//j=temp; 
		
		//2��
		String str[]= {"adafdasf","dafjdogaoif"};
		System.out.println(str.length);//����Ԫ�صĸ���
		System.out.println(str[0].length());//�ַ����ĳ���
		
		//3��
		System.out.println((int)'a');//97
		System.out.println((int)'A');//65
		
		//4��
		//short s=1;s=s+1;����
		//short s=1;s+=1;��ȷ
		
		//5��
		System.out.println("value:"+((5<5)?10.9:9));//9.0
		
		//6��
		char x='x';
		int i=6553600;
		System.out.println(false?i:x);//120
		System.out.println(false?65535:x);// 0~65535 ��x    ���ڴ˷�Χ�ڣ�120
		 
		//7��
		int n=5;
		if(n++ ==6) {//n=5
			System.out.println("n++");
		}
		System.out.println(n);//6
		
		//8��
		int num=32;
		System.out.println(num>>32);//8 8λһ��ѭ��	
		
	}
}

