package demo8_abstractClass_Interface;

class Book{
	
	private String name;

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public void show() {
		Object object=this;
		if(object instanceof Book) { 
			System.out.println("��BOOK�Ķ���");
		}
		if(object instanceof EnglishBook) { 
			System.out.println("��EnglishBook�Ķ���");
		}
	}
	
}

class EnglishBook extends Book{
	private int page;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public void show() {
		Object object=this;
		if(object instanceof Book) { 
			System.out.println("��BOOK�Ķ���");
		}
		if(object instanceof EnglishBook) { 
			System.out.println("��EnglishBook�Ķ���");
		}
	}
}

public class TestInstanceof {
	
	public static void main(String[] args) {
		Book book=new Book();
		book.show();
		EnglishBook englishBook=new EnglishBook();
		englishBook.show();
	}
	
}