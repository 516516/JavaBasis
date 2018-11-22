package demo8_4javaPackage;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Test {
	public static void main(String[] args) {
		Date date=new Date();
		System.out.println("date"+date);
		Calendar calendar=Calendar.getInstance();
		System.out.println("calendar"+calendar.get(Calendar.MONTH));
		Random random=new Random();
		System.out.println(random.nextInt());
	}
}
