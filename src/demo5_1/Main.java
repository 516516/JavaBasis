package demo5_1;
//һά����
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
//		��̬�����ڴ�
		int array[];//�������飬���������ڴ�,����Ҳ����������ڴ棬��ʱ���黹������
//		int array[10];����
		array=new int[10];//�����ڴ棬������ã�����ÿ��Ԫ�ض���һ��Ĭ��ֵ,����:0��������:0.0���ַ�:"\0"��boolean:false���������͵ı���:null
		array[0]=12;
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+"  ");
		}	
		int array1[]= {12,3,23,4,5,67,78,23,56};//�������飬���������ڴ�,����Ҳ����������ڴ棬��ʱ���黹������
//		int array1[9]= {12,3,23,4,5,67,78,23,56};//����
		
		Arrays.sort(array1);//������
		System.out.println();
		for(int i=0;i<array1.length;i++) {
			System.out.print(array1[i]+"  ");
		}
		int a=Arrays.binarySearch(array1, 56);//���ֲ��Һ���
		System.out.println("a:"+a);
		
		int  array2[]=Arrays.copyOf(array1, 3);//��������Ԫ�ص���һ��������
		for(int i=0;i<array2.length;i++) {
			System.out.print(array2[i]+"  ");
		}
		
		System.out.println(Arrays.equals(array1, array2));
		
	}
}
