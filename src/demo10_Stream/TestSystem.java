package demo10_Stream;

import java.io.IOException;

/**
*@auther:����
*@version: 2018��11��25������6:44:08
*@description:	
*/

public class TestSystem {

	/**
	 * @param args
	 * @auther: ����
	 * @version: 2018��11��25������6:46:46
	 * @description:main����
	 */
	
	public static void main(String[] args) {
		
		byte[] b=new byte[128];
		System.out.println("�������ַ���");
		
		try {
			int count=System.in.read(b);
			System.out.println("������ǣ�");
			for(int i=0;i<count;i++) {
				System.out.print(b[i]+" ");
			}
			System.out.println();
			for(int i=0;i<count-2;i++) {
				System.out.print((char)b[i]+" ");
			}
			System.out.println();
			System.out.println("�����ַ��ĸ���Ϊ��"+count);
			Class inClass=System.in.getClass();
			Class outClass=System.out.getClass();
			System.out.println("in���ڵ����ǣ�"+inClass);
			System.out.println("out���ڵ����ǣ�"+outClass);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}