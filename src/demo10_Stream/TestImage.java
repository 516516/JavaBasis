package demo10_Stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestImage {
	
	public static void main(String[] args) throws IOException {
		try {
			FileInputStream fileInputStream=new FileInputStream("E:\\PROJECT\\eclipse\\java\\java_project\\repository\\bin\\demo10_Stream\\video.mp4");
			FileOutputStream fileOutputStream=new FileOutputStream("E:\\PROJECT\\eclipse\\java\\java_project\\repository\\bin\\demo10_Stream\\video1.mp4");
			System.out.println("文件大小："+fileInputStream.available());
			byte[] b=new byte[fileInputStream.available()];
			fileInputStream.read(b);
			fileOutputStream.write(b);
			fileInputStream.close();
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
