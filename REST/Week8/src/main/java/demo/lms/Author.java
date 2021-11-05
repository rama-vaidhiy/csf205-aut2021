package demo.lms;

import java.util.List;



public class Author {
	private int id;
	private String fName;
	private String lName;
	private List<String> aliases;

	public Author(int id, String fName, String lName, List<String> aliases) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.aliases = aliases;
	}

	 
	public int getId() {
		return id;
	}

	 
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	 
	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	 
	public List<String> getAliases() {
		return aliases;
	}

	public void setAliases(List<String> aliases) {
		this.aliases = aliases;
	}

}
