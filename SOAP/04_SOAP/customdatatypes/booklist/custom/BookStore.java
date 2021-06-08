package booklist.custom;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"storeName", "storeLocation","bookList"} )
public class BookStore {
	
	@XmlElementWrapper(name="booklist")
	@XmlElement(name="book")
	private ArrayList<Book> bookList;
	
	public BookStore() {
		super();
		bookList = new ArrayList<Book>();
		createBookStore();
	}


	private String storeName;
	private String storeLocation;
	/**
	 * @return the storeName
	 */
	public String getStoreName() {
		return storeName;
	}
	/**
	 * @param storeName the storeName to set
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	/**
	 * @return the storeLocation
	 */
	public String getStoreLocation() {
		return storeLocation;
	}
	/**
	 * @param storeLocation the storeLocation to set
	 */
	public void setStoreLocation(String storeLocation) {
		this.storeLocation = storeLocation;
	}
	/**
	 * @return the bookList
	 */
	public ArrayList<Book> getBookList() {
		return bookList;
	}
	/**
	 * @param bookList the bookList to set
	 */
	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}
	
	
	private void addBook(Book book)
	{
		if(null!=bookList)
		{
			bookList.add(book);
		}
	}
	
	private  void createBookStore()
	{
		
		Book book1 = new Book();
		book1.setId("123");
		book1.setName("Harry Potter and the Philosophers Stone");
		book1.setAuthor("J.K.Rowling");
		book1.setRating(5);
		book1.setIsbn("232322");
		addBook(book1);
		
		
		Book book2= new Book();
		book2.setId("234");
		book2.setName("Ponniyin Selvan");
		book2.setAuthor("Kalki");
		book2.setRating(5);
		book2.setIsbn("1232132132131");
		addBook(book2);

		
	}

}
