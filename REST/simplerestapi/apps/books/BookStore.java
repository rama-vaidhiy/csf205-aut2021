package apps.books;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/** This is the sample BookStore resource which is used to hold 
  * a collection of books in it. This bookstore has a name and a 
  * location to it too. 
  * NOTE: there is no serialisation of the collection of resources
  * as part of this example. It has been left out on purpose.
  * You can also modify it to add functionality for PUT and DELETE
  * along with some serialization. 
 */

@Path("/bookstore")
public class BookStore {
	
	private ArrayList<Book> bookList;
	private String storeName;
	private String storeLocation;
	
	
	/** Constructor for the bookstore to initialize the bookstore details
	 */
	public BookStore() {
		super();
		storeName="WaterStones";
		storeLocation="Swansea HighStreet";
		bookList = new ArrayList<Book>();
		createBookStore();
	}

	
	/**
	 * @return the storeName
	 */
	@GET
	@Path("/name")
	@Produces(MediaType.TEXT_PLAIN)
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
	@GET
	@Path("/location")
	@Produces(MediaType.TEXT_PLAIN)
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
	@GET
	@Path("/books")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Book> getBookList() {
		return bookList;
	}
	/**
	 * @param bookList the bookList to set
	 */
	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}
	
	/**
	 * @param id the book id which will be used to 
	 * extract the book from the list
	 * This uses the QueryParameter - not recommended
	 * but given here to illustrate the use of QueryParams
	 */
	@GET
	@Path("/bookbyid")
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBookFromID(@QueryParam("id") String id)
	{
		for(Book book:bookList)
		{
			if(book.getId().equalsIgnoreCase(id))
			{
				return book;
			}
		}
		return null;
	}
	
	/**
	 * @param id the book id which will be used to 
	 * extract the book from the list
	 * This uses the PathParam -recommended
	 * This informs that the path in the URI contains
	 * an ID which corresponds to the book id thereby
	 * ensuring to represent the book as a resource
	 */

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBookFromID2(@PathParam("id") String id)
	{
		for(Book book:bookList)
		{
			if(book.getId().equalsIgnoreCase(id))
			{
				return book;
			}
		}
		return null;
	}
	
	/**
	 * @param mybooks the list of books to be added
	 * Uses the POST method to add one or more books
	 * to the collection
	 */
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addNewBooksFromUser( List<Book> mybooks)
	{
		
		if(null!=mybooks)
		{
			for(Book b: mybooks)
			{
				boolean addedSuccessfully = false;
				addBook(b);
				for(Book savedBook:bookList)
				{
					System.out.println(b.getName()+ " == "+savedBook.getName());
					if((savedBook.getId().equalsIgnoreCase(b.getId())))
					{
						addedSuccessfully = true;
					}
				}
				if(!addedSuccessfully)
				{
					return "Not all books added successfully!";
				}
			}
			
		}
		
		return "Successful";
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
