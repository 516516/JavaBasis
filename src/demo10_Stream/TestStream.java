package demo10_Stream;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestStream {

	public static void main(String[] args) throws IOException {
		FileInputStream fileInputStream;
		FileOutputStream fileOutputStream = null;
		int ch;
		int data;
		
		fileInputStream=new FileInputStream(FileDescriptor.in);
		try {
			fileOutputStream=new FileOutputStream("E:\\PROJECT\\eclipse\\java\\java_project\\repository\\bin\\demo10_Stream\\myfile.txt");
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�û�ҵ�");
			e.printStackTrace();
		}
		System.out.println("�����ַ�������#���Ž�������");
		while((ch=fileInputStream.read())!=(int)'#') {
			fileOutputStream.write(ch);
		}
		fileInputStream.close();
		fileOutputStream.close();
		
		
		fileInputStream=new FileInputStream("E:\\PROJECT\\eclipse\\java\\java_project\\repository\\bin\\demo10_Stream\\myfile.txt");
		fileOutputStream=new FileOutputStream(FileDescriptor.out);
		while(fileInputStream.available()>0) {
			data=fileInputStream.read();
			fileOutputStream.write(data);
		}
		fileInputStream.close();
		fileOutputStream.close();
	}

}
