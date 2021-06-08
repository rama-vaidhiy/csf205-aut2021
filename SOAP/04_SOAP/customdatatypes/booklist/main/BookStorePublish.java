package booklist.main;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

import booklist.custom.BookStore;

@WebService
@SOAPBinding( style = SOAPBinding.Style.DOCUMENT )
public class BookStorePublish {

	private BookStore bs;
	public BookStorePublish() {
		super();
		bs = new BookStore();
		bs.setStoreName("Waterstones");
		bs.setStoreLocation("Swansea High Street");
	}

	
	
	
	
	@WebMethod
	public BookStore getBookStore()
	{
		return bs;
	}
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9876/bookstores", new BookStorePublish());

	}

}
