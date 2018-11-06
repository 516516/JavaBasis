package demo4_2;

public class Main4 {

	public static void main(String[] args) {
		final int MAX=16;
		int a=0,b=1,k=2,c=0;
		System.out.print(a+" "+b+" ");
		while(k<=MAX) {
			c=a+b;
			a=b;
			b=c;
			System.out.print(c);
			if(k<=15) {
				System.out.print(" ");
			}
			k++;
		}
	}

}
