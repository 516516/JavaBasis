package demo10_Stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file_dir=new File("E:\\Eclipse_workspace\\maven_project\\JavaBasis\\src\\demo10_Stream\\testCreatFile");
		
		//		创建文件夹
		if(!file_dir.exists()) {
			file_dir.mkdir();
		}
		
		//		在指定文件夹下创建文件
		if(file_dir.isDirectory()) {
			File newFile=new File(file_dir,"newfile.txt");
			if(!newFile.exists()) {
				try {
					newFile.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("文件名："+newFile.getName());
				System.out.println("文件夹名："+newFile.getParent());
			}
		}
		
		try {
			
			File file_rw=new File("E:\\Eclipse_workspace\\maven_project\\JavaBasis\\src\\demo10_Stream\\testCreatFile\\newfile.txt");
			//创建输入流：
			RandomAccessFile randomAccessFile = null;
			if(file_rw.canRead()&&file_rw.canWrite()&&file_rw.exists()) {
				randomAccessFile=new RandomAccessFile(file_rw, "rw");
			}
			byte[] bytes="在文本中写入一行文本内容".getBytes();//String.getBytes()方法自动调用系统默认的编码方式
			byte[] bytes2="在文本中写入一行文本内容2".getBytes();//String.getBytes()方法自动调用系统默认的编码方式
			randomAccessFile.write(bytes);
			randomAccessFile.write('\r');
			randomAccessFile.write(bytes2);
			
			//创建输出流：
			RandomAccessFile randomAccessFile2=null;
			if(file_rw.canRead()&&file_rw.canWrite()&&file_rw.exists()) {
				randomAccessFile2=new RandomAccessFile(file_rw, "rw");
			}
			
			while(randomAccessFile2.getFilePointer()<randomAccessFile2.length()) {
				//编码转换
				System.out.println(new String(randomAccessFile2.readLine().getBytes("ISO-8859-1"),"GBK"));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件不存在");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("将文本信息写入文件时发生错误");
		}
	}
	
}