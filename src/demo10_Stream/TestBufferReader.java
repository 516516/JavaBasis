package demo10_Stream;
/**
*@auther:胡波
*@version: 2018年12月9日下午6:38:53
*@description:	
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestBufferReader {
	public static void main(String args[]) {
		String thisLine;
		int count=0;
		
		try {
			FileReader fReader=new FileReader("E:\\PROJECT\\eclipse\\java\\java_project\\repository\\src\\demo10_Stream\\test.txt");
			BufferedReader bufferedReader=new BufferedReader(fReader);
			while((thisLine=bufferedReader.readLine())!=null) {
				count++;
				System.out.println(thisLine);
			}
			System.out.println("读出数据行数："+count);
		}catch(IOException e){
			System.out.println("error");
		}
		
	}
}
