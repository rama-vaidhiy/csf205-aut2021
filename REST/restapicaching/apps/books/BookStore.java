package apps.books;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import apps.books.exception.BookNotFoundException;


@Path("/bookstore")
public class BookStore {
	
	private ArrayList<Book> bookList;
	private String storeName;
	private String storeLocation;
	private static String APPLICATION_PATH="/BookRestApplication/rest/bookstore";
	

	public BookStore() {
		super();
		System.out.println("Instantiating the BookStore");
		storeName="WaterStones";
		storeLocation="Swansea HighStreet";
		bookList = new ArrayList<Book>();
		createBookStore();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String defaultGetter()
	{
		return "This is a book store called "+this.storeName+ " located @ "+this.storeLocation;
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
	 * Method modified to throw an exception if the provided book id
	 * is not found, instead of returning null
	 * @param id
	 * @return
	 */

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBookFromID2( @PathParam("id") String id)
	{
		for(Book book:bookList)
		{
			if(book.getId().equalsIgnoreCase(id))
			{
				return book;
			}
		}
		//Can use this to tell the client that there is no such book by that
		//id
//		Response rsp = Response.status(Response.Status.NOT_FOUND)
//				.entity("Book with id = "+id+ " not found.")
//				.type("text/plain").build();
//		throw new NotFoundException(rsp);
		//or use the below ExceptionMapped Exception to reuse the exceptions
		//across your application
		throw new BookNotFoundException("Book with id = "+id+ " not found.");
		//if you just return null, the Servlet will deal with how it deems fit.
		//mostly it will just send 204-No Content. 
		//return null;
	}

	
	/**
	 * Additional Method added to illustrate the use of Response objects
	 * Remember that we have to use isbn= because if we just give {isbn}
	 * it will be difficult to distinguish between the {id} and the {isbn}
	 * @param isbn
	 * @return
	 */
	@GET
	@Path("isbn={isbn}")
	public Response getBookFromIsbn( @PathParam("isbn") String isbn)
	{
		for(Book book:bookList)
		{
			if(book.getIsbn().equalsIgnoreCase(isbn))
			{
				SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy");
				  try {
					Date expiryDate = objSDF.parse("20-08-2021");
					ResponseBuilder rspBuilder = Response.ok(book,MediaType.APPLICATION_JSON);
					rspBuilder.expires(expiryDate);
					return rspBuilder.build();
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		//this is another way of sending back 204-No Content
		//except that you are ensuring that it is sent via a proper response
		//object where you can add more details to the header and such.
		return Response.noContent().build();
		//you can also send a response without the exception 
		//by setting a custom status to it.
		//return Response.status(Status.NOT_FOUND).build();
	}
	
	/**
	 * Method to illustrate the use of Expires header for caching
	 * @param isbn
	 * @return
	 */
//	@GET
//	@Path("isbn={isbn}")
//	public Response getBookFromIsbn( @PathParam("isbn") String isbn)
//	{
//		for(Book book:bookList)
//		{
//			if(book.getIsbn().equalsIgnoreCase(isbn))
//			{
//				SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy");
//				  try {
//					Date expiryDate = objSDF.parse("20-08-2021");
//					ResponseBuilder rspBuilder = Response.ok(book,MediaType.APPLICATION_JSON);
//					rspBuilder.expires(expiryDate);
//					return rspBuilder.build();
//					
//				} catch (ParseException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return Response.status(Status.NOT_FOUND).build();
//	}

	/**
	 * Sample code to show the use of cache-control
	 * @param isbn
	 * @return
	 */
//	@GET
//	@Path("isbn={isbn}")
//	public Response getBookFromIsbn( @PathParam("isbn") String isbn)
//	{
//		for(Book book:bookList)
//		{
//			if(book.getIsbn().equalsIgnoreCase(isbn))
//			{
//				CacheControl cc = new CacheControl();
//				cc.setMaxAge(300);
//				cc.setPrivate(true);
//				cc.setNoStore(true);
//				ResponseBuilder rspBuilder = Response.ok(book,MediaType.APPLICATION_JSON);
//				rspBuilder.cacheControl(cc);
//				return rspBuilder.build();		
//			}
//		}
//		return Response.status(Status.NOT_FOUND).build();
//	}


	
	@GET
	@Path("{id}-{author}")
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBookFromIDAndAuthor(@PathParam("id") String id,
					@PathParam("author")String author)
	{
		for(Book book:bookList)
		{
			if(book.getId().equalsIgnoreCase(id) && 
						book.getAuthor().equalsIgnoreCase(author))
			{
				return book;
			}
		}
		return null;
	}
	
	
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
		UriBuilder uribuilder = UriBuilder.fromPath(APPLICATION_PATH+"/{id}");

		Book book1 = new Book();
		book1.setId("123");
		book1.setName("Harry Potter and the Philosophers Stone");
		book1.setAuthor("J.K.Rowling");
		book1.setRating(5);
		book1.setIsbn("232322");
		book1.setLink(uribuilder.build(book1.getId()));
		addBook(book1);
		
		
		Book book2= new Book();
		book2.setId("234");
		book2.setName("Ponniyin Selvan");
		book2.setAuthor("Kalki");
		book2.setRating(5);
		book2.setIsbn("1232132132131");
		book2.setLink(uribuilder.build(book2.getId()));
		addBook(book2);

		
		
	}

}
