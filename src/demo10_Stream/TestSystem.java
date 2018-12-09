package demo10_Stream;

import java.io.IOException;

/**
*@auther:胡波
*@version: 2018年11月25日下午6:44:08
*@description:	
*/

public class TestSystem {

	/**
	 * @param args
	 * @auther: 胡波
	 * @version: 2018年11月25日下午6:46:46
	 * @description:main函数
	 */
	
	public static void main(String[] args) {
		
		byte[] b=new byte[128];
		System.out.println("请输入字符：");
		
		try {
			int count=System.in.read(b);
			System.out.println("输入的是：");
			for(int i=0;i<count;i++) {
				System.out.print(b[i]+" ");
			}
			System.out.println();
			for(int i=0;i<count-2;i++) {
				System.out.print((char)b[i]+" ");
			}
			System.out.println();
			System.out.println("输入字符的个数为："+count);
			Class inClass=System.in.getClass();
			Class outClass=System.out.getClass();
			System.out.println("in所在的类是："+inClass);
			System.out.println("out所在的类是："+outClass);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}