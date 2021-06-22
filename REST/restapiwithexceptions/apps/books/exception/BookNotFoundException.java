package apps.books.exception;

public class BookNotFoundException 
	extends RuntimeException {

	public BookNotFoundException(String s)
	{
		super(s);
	}

}
