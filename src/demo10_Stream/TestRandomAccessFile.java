package demo10_Stream;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


public class TestRandomAccessFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StringBuffer stringBufferDir=new StringBuffer();
		System.out.println("�����ļ�·����");
		char ch;
		while((ch=(char)System.in.read())!='\r') {
			stringBufferDir.append(ch);
		}
		
		File dir=new File(stringBufferDir.toString());
		System.out.println("�����������ļ�����");
		
		StringBuffer stringBufferFileName=new StringBuffer();
		char c;
		while((c=(char)System.in.read())!='\r') {
			stringBufferFileName.append(c);
		}
		
		stringBufferFileName.replace(0, 1, "");
		File readFrom=new File(dir,stringBufferFileName.toString());
		
		if(readFrom.isFile()&&readFrom.canRead()&&readFrom.canWrite()) {
			RandomAccessFile raFile=new RandomAccessFile(readFrom, "rw");
			while(raFile.getFilePointer()<raFile.length()) {
				System.out.println(new String(raFile.readLine().getBytes("ISO-8859-1"),"GBK"));//�����ȡ��������
			}
			raFile.close();
		}else {
			System.out.println("�ļ����ɶ�");
		}
	}
}
