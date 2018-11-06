package demo4_2;
//if else Ç¶Ì×Ñ­»·
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		int score;
		char grade;
		Scanner scanner=new Scanner(System.in);
		score=scanner.nextInt();
		if(score>=90) {
			grade='A';
		}else if(score>=80) {
			grade='B';
		}else if(score>=80) {
			grade='C';
		}else if(score>=70) {
			grade='D';
		}else if(score>=60) {
			grade='E';
		}else {
			grade='F';
		}
		System.out.println(grade);
	}
}
