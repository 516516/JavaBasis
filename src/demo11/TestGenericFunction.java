package demo11;


public class TestGenericFunction {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer intArray[]= {1,2,3,4,5,6,7,8,9};
		String strArray[]= {"ceshi","hadahg","�������","�Ƽ���","��","��","�޺ô�"};
		int testint[]= {1,2,3,4,5,6,7,8,9};
		display(intArray);
		display(strArray);
		//display(testint);Ϊ�������ͻ����
	}
	public static <T>void display(T[] list){
		for(int i=0;i<list.length;i++) {
			System.out.print(list[i]+"  ");
		}
	}
}
