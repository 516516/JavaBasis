package demo5_4;

import java.util.Scanner;

public class Test11 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String string=scanner.nextLine();
		int countLetter=0,countNum=0,countOher=0;
		for(int i=0;i<string.length();i++) {
			char c=string.charAt(i);
			if(c>='0'&&c<='9') {
				countNum++;
			}else if((c>='a'&&c<='z')||(c>='A'&&c<='Z')) {
				countLetter++;
			}else {
				countOher++;
			}
		}
		
		System.out.println("countLetter:"+countLetter);
		System.out.println("countNum:"+countNum);
		System.out.println("countOher:"+countOher);
	}
	
}
