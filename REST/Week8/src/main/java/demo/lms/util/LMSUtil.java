package demo.lms.util;

import java.util.ArrayList;
import java.util.List;

import demo.lms.Author;
import demo.lms.Book;
import demo.lms.Magazine;

public class LMSUtil {

	private LMSUtil() {
		//does nothing.. just to prevent anyone from instantiating it.
		//does it mean it is a singleton????
	}
	
	public static List<Book> createBooks()
	{
		List<Book> books = new ArrayList<Book>();
		books.add(createBook1());
		books.add(createBook2());
		books.add(createBook3());
		books.add(createBook4());
		books.add(createBook5());
		books.add(createBook6());
		return books;
	}
	
	public static List<Magazine> createMagazines()
	{
		List<Magazine> mags = new ArrayList<Magazine>();
		mags.add(createMag1());
		mags.add(createMag2());
		mags.add(createMag3());
	
		return mags;
	}
	
	
	private static Book createBook1()
	{
		List<String> aliases = new ArrayList<String>();
		aliases.add("Charles Wogan");
		Author a = new Author(1,"Brian","Flynn",aliases);
		List<Author> authors = new ArrayList<Author>();
		authors.add(a);
		List<String> genres = new ArrayList<String>();
		genres.add("Mystery");
		genres.add("Thriller");
		genres.add("Detective");
		Book b = new Book("The Billiard Room Mystery","English",genres,authors);
		b.setId(1);
		return b;
	}
	private static Book createBook2()
	{
		List<String> aliases = new ArrayList<String>();
		aliases.add("Charles Wogan");
		Author a = new Author(1,"Brian","Flynn",aliases);
		List<Author> authors = new ArrayList<Author>();
		authors.add(a);
		List<String> genres = new ArrayList<String>();
		genres.add("Mystery");
		genres.add("Thriller");
		genres.add("Detective");
		Book b = new Book("The Murders near Mapleton","English",genres,authors);
		b.setId(2);
		return b;
	}
	private static Book createBook3()
	{
		List<String> aliases = new ArrayList<String>();
		aliases.add("John Rhode");
		aliases.add("Miles Burton");
		Author a = new Author(1,"Cecil","Waye",aliases);
		List<Author> authors = new ArrayList<Author>();
		authors.add(a);
		List<String> genres = new ArrayList<String>();
		genres.add("Mystery");
		genres.add("Thriller");
		genres.add("Detective");
		Book b = new Book("Murder at Monks Barn","English",genres,authors);
		b.setId(3);
		return b;
	}
	private static Book createBook4()
	{
		List<String> aliases = new ArrayList<String>();
		aliases.add("John Rhode");
		aliases.add("Miles Burton");
		Author a = new Author(1,"Cecil","Waye",aliases);
		List<Author> authors = new ArrayList<Author>();
		authors.add(a);
		List<String> genres = new ArrayList<String>();
		genres.add("Mystery");
		genres.add("Thriller");
		genres.add("Detective");
		Book b = new Book("The Prime Ministers Pencil","English",genres,authors);
		b.setId(4);
		return b;
	}
	
	private static Book createBook5()
	{
		List<String> aliases = new ArrayList<String>();
		aliases.add("Robert Galbriath");
		Author a = new Author(1,"Joanne","Rowling",aliases);
		List<Author> authors = new ArrayList<Author>();
		authors.add(a);
		List<String> genres = new ArrayList<String>();
		genres.add("Fiction");
		genres.add("Young Adult");
		genres.add("Fantasy");
		Book b = new Book("Harry Potter and the Sorcerer's Stone","English",genres,authors);
		b.setId(5);
		return b;
	}
	private static Book createBook6()
	{
		List<String> aliases = new ArrayList<String>();
		Author a = new Author(1,"Terry","Pratchett",aliases);
		Author a1 = new Author(2,"Neil","Gaiman",aliases);
		List<Author> authors = new ArrayList<Author>();
		authors.add(a);
		authors.add(a1);
		List<String> genres = new ArrayList<String>();
		genres.add("Fiction");
		genres.add("Humour");
		genres.add("Fantasy");
		Book b = new Book("Good Omens: The Nice and Accurate Prophecies of Agnes Nutter, Witch","English",genres,authors);
		b.setId(6);
		return b;
	}
	
	private static Magazine createMag1()
	{
		Magazine m= new Magazine("BBC Gardeners World","Immediate Media Company", "English");
		return m;
	}
	private static Magazine createMag2()
	{
		Magazine m= new Magazine("BBC Good Food","Immediate Media Company", "English");
		return m;
	}
	
	private static Magazine createMag3()
	{
		Magazine m= new Magazine("Delicious","Eye to Eye Media", "English");
		return m;
	}

}
