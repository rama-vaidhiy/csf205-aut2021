package demo.lms;

import java.util.List;

 

public class Book {

	private int id;
	

	private String name;
	private String language;
	private List<String> genres;
	private List<Author> authors;
	
	public Book() {
		super();
	}
	
	public Book(String name, String language, List<String> genres, List<Author> authors) {
		super();
		this.name = name;
		this.language = language;
		this.genres = genres;
		this.authors = authors;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	 
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	 
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	 
	public List<String> getGenres() {
		return genres;
	}
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
	
	 
	public List<Author> getAuthors() {
		return authors;
	}
	
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	
	public Author getAuthorDetails(int id)
	{
		for (Author author : authors) {
			if(author.getId() == id)
			{
				return author;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "Book [name=" + name + ", language=" + language + ", genres=" + genres + ", authors=" + authors + "]";
	}
	
	
	
}
