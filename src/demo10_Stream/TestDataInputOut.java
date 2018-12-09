package demo10_Stream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
*@auther:
*@version: 2018��11��25������2:11:20
*@description: ��������������������÷�
*/
public class TestDataInputOut {

	/**
	 * @param args
	 * @auther: 
	 * @version: 2018��11��25������2:50:37
	 * @description:main����
	 */
	public static void main(String[] args) {
		
		FileOutputStream fileOutputStream;
		FileInputStream fileInputStream;
		DataOutputStream dataOutputStream;
		DataInputStream dataInputStream;
//		д�ļ�
		try {
			fileOutputStream=new FileOutputStream("E:\\PROJECT\\eclipse\\java\\java_project\\repository\\src\\demo10_Stream\\testDataIO.txt");
			dataOutputStream=new DataOutputStream(fileOutputStream);
			dataOutputStream.writeInt(100);
			dataOutputStream.writeByte(20);
			dataOutputStream.writeShort(100);
			dataOutputStream.writeLong(2000000000);
			dataOutputStream.writeFloat(20.04F);
			dataOutputStream.writeDouble(20.098765);
			dataOutputStream.writeBoolean(false);
			dataOutputStream.writeChar('c');
			dataOutputStream.writeChars("adoahgaohgioahgaioh");
		} catch (Exception e) {
		}
//		���ļ�
		try {
			fileInputStream=new FileInputStream("E:\\PROJECT\\eclipse\\java\\java_project\\repository\\src\\demo10_Stream\\testDataIO.txt");
			dataInputStream=new DataInputStream(fileInputStream);
			System.out.println(dataInputStream.readInt());
			System.out.println(dataInputStream.readByte());
			System.out.println(dataInputStream.readShort());
			System.out.println(dataInputStream.readLong());
			System.out.println(dataInputStream.readFloat());
			System.out.println(dataInputStream.readDouble());
			System.out.println(dataInputStream.readBoolean());
			System.out.println(dataInputStream.readChar());
			
			char chare;
			while((chare=dataInputStream.readChar())!='\0') {
				System.out.print(chare);
			}
			dataInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�ļ�δ�ҵ���������");
		}
	}
}
