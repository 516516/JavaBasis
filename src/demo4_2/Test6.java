package demo4_2;
//
public class Test6 {
	
	public static void main(String[] args) {
		for(int i=0;i<5;i++) {
			int sum=0,m=0;
			for(int j=0;j<5-i;j++) {
				while(m<(i+j+1)) {
					sum+=m++;//此行前共有多少个元素
				}
				int n=sum+j+1;
				System.out.print(n+" ");
			}
			System.out.println();
		}
	}
}
