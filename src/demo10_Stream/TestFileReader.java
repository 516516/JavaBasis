package demo10_Stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
*@auther:����
*@version: 2018��11��25������7:16:34
*@description:	FileReaderʵ�����
*/
public class TestFileReader {

	/**
	 * @param args
	 * @auther: ����
	 * @version: 2018��11��25������7:30:18
	 * @description:main����
	 */
	public static void main(String[] args) {
		char []chars=new char[500];
		try {
			FileReader fileReader=new FileReader("E:\\PROJECT\\eclipse\\java\\java_project\\repository\\src\\demo10_Stream\\test.txt");
			int num=fileReader.read(chars);
			String string=new String(chars, 0, num);
			System.out.println("��ȡ���ַ�����Ϊ��"+num+",���������£�");
			System.out.println(string);
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
