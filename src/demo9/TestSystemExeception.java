package demo9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestSystemExeception {
	
	public static void main(String[] args) {
		String str;
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				System.out.print("请输入字符串");
				str=buf.readLine();
				if(str.length()>0) {
					break;
				}else {
					throw new IOException();
				}
			} catch (IOException e) {
				System.out.println("必须输入字符串");
				continue;
			}
		}
		String string=str.toUpperCase();
		System.out.println("转换后的字符串为："+string);
	}
}
