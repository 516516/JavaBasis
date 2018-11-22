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
			System.out.println("是BOOK的对象");
		}
		if(object instanceof EnglishBook) { 
			System.out.println("是EnglishBook的对象");
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
			System.out.println("是BOOK的对象");
		}
		if(object instanceof EnglishBook) { 
			System.out.println("是EnglishBook的对象");
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