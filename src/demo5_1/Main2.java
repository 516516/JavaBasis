package demo5_1;
//×Ö·û´®£º
public class Main2 {

	public static void main(String[] args) {
		
		String string=new String("string");
		String str1="string";
		String str4="string";
		String str2="str";
		String str3="ing";
		str3=str2+str3;
		
		System.out.println(str1.equals(str4));
		System.out.println(str1.equals(string));
		System.out.println(str1.equals(str3));
		System.out.println(str1==string);
		System.out.println(str1==str4);
		System.out.println(str1==str3);
		
	}
}
