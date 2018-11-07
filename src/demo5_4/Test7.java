package demo5_4;

public class Test7 {

	public static void main(String[] args) {
		int Num[]=new int[30];
		for(int i=0;i<Num.length;i++) {
			Num[i]=1;
		}
		int flag=1,count=0,countNum=0;
		while(1==flag) {
			flag=0;
			for(int i=0;i<Num.length;i++) {
				if(1==Num[i]) {
					count+=1;
					if(0==count%13) {
						System.out.print((i+1)+" ");
						Num[i]=0;
						countNum+=1;
						if(countNum<15) {
							flag=1;
						}else {
							flag=0;
							break;
						}
					}
				}
			}
		}
	}
}
