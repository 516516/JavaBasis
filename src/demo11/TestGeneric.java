package demo11;

public class TestGeneric<T> {
	private T obj;
	
	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestGeneric<String> testGenericStr=new TestGeneric<String>();
		testGenericStr.setObj("²¨²¨");
		String name=testGenericStr.getObj();
		TestGeneric<Integer> testGenericInt=new TestGeneric<Integer>();
		testGenericInt.setObj(14);
		int age=testGenericInt.getObj();
		System.out.println("ĞÕÃû£º"+name+"    "+"ÄêÁä£º"+age);
	}

}
