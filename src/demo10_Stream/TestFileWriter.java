package demo10_Stream;

import java.io.FileWriter;
import java.io.IOException;

/**
*@auther:
*@version: 2018年11月26日上午10:41:52
*@description:	测试FileWriter的实验代码
*/
public class TestFileWriter {
	public static void main(String[] args) {
		try {
			FileWriter fWriter=new FileWriter("E:\\PROJECT\\eclipse\\java\\java_project\\repository\\src\\demo10_Stream\\testfileWriter.txt", true);
			char charbuf[]= {'h','n'};
			String string="欢迎使用java！！！";
			fWriter.write(charbuf);
			fWriter.write(string);
			fWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}