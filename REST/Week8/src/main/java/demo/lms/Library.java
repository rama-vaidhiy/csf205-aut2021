package demo.lms;

import java.util.List;
 

import demo.lms.util.LMSUtil;

public class Library {
	
	private String name;
	private String location;
	private List<Book> books;
	private List<Magazine> magazines;
	
	public Library() {
		super();
		name="Swansea Bibliophile Society";
		location="Room of Requirement, Faraday Building, Singleton Campus";
		books = LMSUtil.createBooks();
		magazines = LMSUtil.createMagazines();
	}
	
	public String getDefaultData() {
		return "Welcome to the "+name + " located @ the "+location;
	}
	
	 
	public String getLibraryName() {
		return name;
	}
	
 
	public String getLibraryLocation() {
		return location;
	}
	
 
	public List<Book> getListOfBooks(){
		return books;
	}
	
	
	 
	public List<Magazine> getListOfMagazines(){
		return magazines;
	}
	
 
	public Book getBookByAuthor(  int id) {
		
	 
		for (Book book : books) {
			if(book.getId()==id)
			{
				return book;
			}
		}
		return new Book();
		
	}
	
	

}
