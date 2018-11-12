package demo6_2_4;

public class TestTranspose {

	public static void main(String[] args) {
		int array[][]= {{1,2,3},{4,5,6},{5,6,7}};
		int result[][]=transpose(array);
		for(int i=0;i<result.length;i++) {
			for(int j=0;j<result[i].length;j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}
	
	public static int[][] transpose(int array[][]){
		int result[][]=new int[array[0].length][array.length];
		
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				result[j][i]=array[i][j];
			}
		}
		return result;
	}
	
}
