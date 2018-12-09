package demo10_Stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
*@auther:胡波
*@version: 2018年12月9日下午7:48:10
*@description:	
*/
public class TestBufferWriter {
	public static void main(String args[]) throws IOException {
		
		String string=new String();
		
		try {
			BufferedReader bufferedReader=new BufferedReader(new FileReader("E:\\PROJECT\\eclipse\\java\\java_project\\repository\\src\\demo10_Stream\\test.txt"));
			BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("E:\\PROJECT\\eclipse\\java\\java_project\\repository\\src\\demo10_Stream\\test1.txt"));
			
			while((string=bufferedReader.readLine())!=null) {
				System.out.println(string);
				bufferedWriter.write(string);
				bufferedWriter.newLine();//写入回车换行符
			}
			bufferedWriter.flush();
			bufferedWriter.close();
			bufferedReader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
