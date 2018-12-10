package demo10_Stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

/**
*@auther:胡波
*@version: 2018年12月9日下午8:49:00
*@description:	
*/
public class TestFile {

	/**
	 * @param args
	 * @auther: 胡波
	 * @version: 2018年12月9日下午10:00:42
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
		
		System.out.println("输入文件名：");
		
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
		System.out.println("输入完毕："+file_name+"  "+"长度："+file_name.length());
		File file=new File(fdir1,file_name);
		
		if(file.isFile()) {
			System.out.println("视为文件处理");
			System.out.println(file.getName());
			System.out.println(file.getPath());
			System.out.println(file.length());
		}
		
		if(file.isDirectory()) {
			System.out.println("文件夹 视为");
		}
		
		String str1[]=fdir1.list();
		for(int i=0;i<str1.length;i++) {
			System.out.println("str1["+i+"]:"+str[i]);
		}
		
		
	}
}
