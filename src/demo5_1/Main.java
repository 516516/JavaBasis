package demo5_1;
//一维数组
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
//		动态分配内存
		int array[];//声明数组，并不分配内存,并且也不允许分配内存，此时数组还不可用
//		int array[10];错误
		array=new int[10];//分配内存，数组可用，并且每个元素都有一个默认值,整数:0、浮点数:0.0、字符:"\0"、boolean:false、引用类型的变量:null
		array[0]=12;
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+"  ");
		}	
		int array1[]= {12,3,23,4,5,67,78,23,56};//声明数组，并不分配内存,并且也不允许分配内存，此时数组还不可用
//		int array1[9]= {12,3,23,4,5,67,78,23,56};//错误
		
		Arrays.sort(array1);//排序函数
		System.out.println();
		for(int i=0;i<array1.length;i++) {
			System.out.print(array1[i]+"  ");
		}
		int a=Arrays.binarySearch(array1, 56);//二分查找函数
		System.out.println("a:"+a);
		
		int  array2[]=Arrays.copyOf(array1, 3);//拷贝部分元素到另一个数组中
		for(int i=0;i<array2.length;i++) {
			System.out.print(array2[i]+"  ");
		}
		
		System.out.println(Arrays.equals(array1, array2));
		
	}
}
