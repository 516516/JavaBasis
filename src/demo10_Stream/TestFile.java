package demo10_Stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

/**
*@auther:����
*@version: 2018��12��9������8:49:00
*@description:	
*/
public class TestFile {

	/**
	 * @param args
	 * @auther: ����
	 * @version: 2018��12��9������10:00:42
	 * @description:
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String string_of_filedir="E:\\Eclipse_workspace\\maven_project\\JavaBasis\\src\\demo10_Stream";
		String string_of_filedir1="E:\\Eclipse_workspace\\maven_project\\JavaBasis\\src\\demo10_Stream";
		File fdir1=new File(string_of_filedir);
		File fdir2=new File(string_of_filedir1);
		
		System.out.println("exists:"+fdir1.exists());
		System.out.println("isFile:"+fdir1.isFile());
		System.out.println("isDirectory:"+fdir1.isDirectory());
		System.out.println("getName:"+fdir1.getName());
		System.out.println("getPath:"+fdir1.getPath());
		System.out.println("length:"+fdir1.length());
		System.out.println("canRead:"+fdir1.canRead());
		System.out.println("canWrite:"+fdir1.canWrite());
		System.out.println("equals:"+fdir1.equals(fdir2));
		String str[]=fdir1.list();
		
		for(int i=0;i<str.length;i++) {
			System.out.println("str["+i+"]:  "+str[i]);
		}
		
		System.out.println("�����ļ�����");
		
		Scanner scanner=new Scanner(System.in);
		
		
		InputStreamReader inputStreamReader=new InputStreamReader(System.in);
		BufferedReader inp=new BufferedReader(inputStreamReader);
		
		String file_name = null;
		try {
			file_name = inp.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("������ϣ�"+file_name+"  "+"���ȣ�"+file_name.length());
		File file=new File(fdir1,file_name);
		
		if(file.isFile()) {
			System.out.println("��Ϊ�ļ�����");
			System.out.println(file.getName());
			System.out.println(file.getPath());
			System.out.println(file.length());
		}
		
		if(file.isDirectory()) {
			System.out.println("�ļ��� ��Ϊ");
		}
		
		String str1[]=fdir1.list();
		for(int i=0;i<str1.length;i++) {
			System.out.println("str1["+i+"]:"+str[i]);
		}
		
		
	}
}
