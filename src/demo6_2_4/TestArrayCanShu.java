package demo6_2_4;
public class TestArrayCanShu {
	public static void main(String[] args) {
		int array[]= {2,3,1,4,5,5,4,3,-1,-2,9};
		int arrayResult[][]=getMinAndLocation(array);
		System.out.println("最小元素下标："+arrayResult[0][0]);
		System.out.println("最大元素值："+arrayResult[0][1]);
	}
	public static int[][] getMinAndLocation(int array[]){
		int result[][]=new int[1][2];
		result[0][0]=0;
		result[0][1]=array[0];
		for(int i=0;i<array.length;i++) {
			if(array[i]<result[0][1]) {
				result[0][0]=i;
				result[0][1]=array[i];
			}	
		}
		return result;
	}
}
