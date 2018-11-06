package demo4_2;
//Ë®ÏÉ»¨Êý£º
public class Test3 {
	public static void main(String args[]) {
		for(int i=1;i<10;i++) {
			for(int j=0;j<10;j++) {
				for(int k=0;k<10;k++) {
					int num=i*100+j*10+k;
					int num2=i*i*i+j*j*j+k*k*k;
					if(num==num2) {
						System.out.println(num);
					}
				}
			}
		}
		
		for(int i=100;i<=999;i++) {
			int a=i/100;
			int b=(i-a*100)/10;
			int c=i-a*100-b*10;
			if(i==(a*a*a+b*b*b+c*c*c)) {
				System.out.print(i+" ");
			}
		}
		
	}
}
