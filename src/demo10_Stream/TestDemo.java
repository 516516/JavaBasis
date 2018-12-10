package demo10_Stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file_dir=new File("E:\\Eclipse_workspace\\maven_project\\JavaBasis\\src\\demo10_Stream\\testCreatFile");
		
		//		�����ļ���
		if(!file_dir.exists()) {
			file_dir.mkdir();
		}
		
		//		��ָ���ļ����´����ļ�
		if(file_dir.isDirectory()) {
			File newFile=new File(file_dir,"newfile.txt");
			if(!newFile.exists()) {
				try {
					newFile.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("�ļ�����"+newFile.getName());
				System.out.println("�ļ�������"+newFile.getParent());
			}
		}
		
		try {
			
			File file_rw=new File("E:\\Eclipse_workspace\\maven_project\\JavaBasis\\src\\demo10_Stream\\testCreatFile\\newfile.txt");
			//������������
			RandomAccessFile randomAccessFile = null;
			if(file_rw.canRead()&&file_rw.canWrite()&&file_rw.exists()) {
				randomAccessFile=new RandomAccessFile(file_rw, "rw");
			}
			byte[] bytes="���ı���д��һ���ı�����".getBytes();//String.getBytes()�����Զ�����ϵͳĬ�ϵı��뷽ʽ
			byte[] bytes2="���ı���д��һ���ı�����2".getBytes();//String.getBytes()�����Զ�����ϵͳĬ�ϵı��뷽ʽ
			randomAccessFile.write(bytes);
			randomAccessFile.write('\r');
			randomAccessFile.write(bytes2);
			
			//�����������
			RandomAccessFile randomAccessFile2=null;
			if(file_rw.canRead()&&file_rw.canWrite()&&file_rw.exists()) {
				randomAccessFile2=new RandomAccessFile(file_rw, "rw");
			}
			
			while(randomAccessFile2.getFilePointer()<randomAccessFile2.length()) {
				//����ת��
				System.out.println(new String(randomAccessFile2.readLine().getBytes("ISO-8859-1"),"GBK"));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ļ�������");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ı���Ϣд���ļ�ʱ��������");
		}
	}
	
}