package demo.lms;


public class Magazine {

	private String name;
	private String publisher;
	private String language;
	

	public Magazine(String name,String publisher, String language) {
		super();
		this.name = name;
		this.publisher = publisher;
		this.language = language;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "Magazine [name=" + name + ", publisher=" + publisher + ", language=" + language + "]";
	}
	
	
	
}
