package demo9;

public class TestFunctionException_throw {
	
	public static void check(String str1)throws NullPointerException {
		if(str1.length()>2) {
			str1=null;
			System.out.println(str1.length());
		}
		char ch;
		for(int i=0;i<str1.length();i++) {
			ch=str1.charAt(i);
			if(!Character.isDigit(ch));{
				throw new NumberFormatException();
			}
		}
	}
	
	public static void main(String[] args) {
		int num;
		try {
			check("2s");
			num=Integer.parseInt("2s");
			if(num>60) {
				System.out.println("成绩为："+num+" 及格");
			}else {
				System.out.println("成绩为："+num+" 不及格");
			}
		}catch (NullPointerException e) {
			System.out.println("空指针异常:"+e.toString());
		}catch (NumberFormatException e) {
			System.out.println("输入不是数值类型");
		}catch (Exception e) {
			System.out.println("命令行没有提供参数");
		}finally {
			System.out.println("程序执行结束");
		}
	}
}
