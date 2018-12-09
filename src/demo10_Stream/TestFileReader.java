package demo10_Stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
*@auther:胡波
*@version: 2018年11月25日下午7:16:34
*@description:	FileReader实验代码
*/
public class TestFileReader {

	/**
	 * @param args
	 * @auther: 胡波
	 * @version: 2018年11月25日下午7:30:18
	 * @description:main函数
	 */
	public static void main(String[] args) {
		char []chars=new char[500];
		try {
			FileReader fileReader=new FileReader("E:\\PROJECT\\eclipse\\java\\java_project\\repository\\src\\demo10_Stream\\test.txt");
			int num=fileReader.read(chars);
			String string=new String(chars, 0, num);
			System.out.println("读取的字符个数为："+num+",其内容如下：");
			System.out.println(string);
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
