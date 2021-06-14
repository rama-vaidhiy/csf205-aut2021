/**
 * 
 */
package trip.stthomas;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author rama_swuni
 *
 */
@XmlRootElement(name="place")
public class Place {
	
	private String city;
	private String place;
	private String desc;
	private boolean visited;
	
	/**
	 * @param visited the visited to set
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}


	
	/**
	 * @return the city
	 */
	@XmlElement(name="City")
	public String getCity() {
		return city;
	}



	/**
	 * @return the place
	 */
	@XmlElement(name="Place of Interest")
	public String getPlace() {
		return place;
	}

	/**
	 * @return the desc
	 */
	@XmlElement(name="Description")
	public String getDesc() {
		return desc;
	}

	/**
	 * @return the visited
	 */
	@XmlElement(name="isVisited")
	public boolean isVisited() {
		return visited;
	}

	/**
	 * @return the id
	 */
	@XmlAttribute
	public int getId() {
		return id;
	}

	private int id;

	/**
	 * 
	 */
	public Place() {
		super();
	}
	
	public Place(int id, String city, String place, String desc)
	{
		this.id = id;
		this.city = city;
		this.place = place;
		this.desc = desc;
		this.visited = false;
	}

}
