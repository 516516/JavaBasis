package demo6_2_4;

public class TestTranspose {

	public static void main(String[] args) {
		int array[][]= {{1,2,3},{4,5,6},{5,6,7}};
		int result[][]=transpose(array);
		for(int i=0;i<result.length;i++) {
			for(int j=0;j<result[i].length;j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		
		int sumResult[][]=getColumnSum(array);
		for(int i=0;i<sumResult.length;i++) {
			for(int j=0;j<sumResult[i].length;j++) {
				System.out.print(sumResult[i][j]+" ");
			}
		}
	}
	
	public TestTranspose() {
		this(3);
	}
	
	public TestTranspose(int a) {
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
	
	public static int[][] getColumnSum(int array[][]){ 
		int result[][]=new int[1][array[0].length];
		for(int i=0;i<array[0].length;i++) {
			int sum=0;
			for(int j=0;j<array.length;j++) {
				sum+=array[i][j];
			}
			result[0][i]=sum;
		}
		return result;
	}
	
}
