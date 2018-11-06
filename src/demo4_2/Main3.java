package demo4_2;
//switch case
import java.util.Calendar;
import java.util.Scanner;


public class Main3 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Calendar calendar=Calendar.getInstance();
		int year=calendar.get(calendar.YEAR);
		System.out.println(year);
		int month=scanner.nextInt();
		int day;
		switch (month) {
		
		case 2:
			if(0==year%4&&0!=year%100||0==year%400) {
				day=29;
			}else {
				day=28;
			}
			System.out.println(day);
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 12:
			day=31;
			System.out.println(day);
			break;
			
		default:
			day=30;
			System.out.println(day);
			break;
		}
	}

}
