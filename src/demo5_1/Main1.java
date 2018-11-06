package demo5_1;
//二维数组：
public class Main1 {

	public static void main(String[] args) {
		
		int array[][]=new int[2][];//对
		int array1[][]=new int[2][3];//对
		int array2[][];
		array2=new int[2][];//对
		int array3[][]= {{1,2,3,4},{2,3,4}};//对
		
//		int array3[2][4]= {{1,2,3,4},{2,3,4}};//错
		
		for(int i=0;i<array3.length;i++) {
			for(int j=0;j<array3[i].length;j++) {
				System.out.print(array3[i][j]+"  ");
			}
			System.out.println();
		}
		
//		int array2[2][]=new int[][];//错
//		int array3[][3]=new int[][];//错
//		int array4[][]=new int[][3];//错
		
	}

}
