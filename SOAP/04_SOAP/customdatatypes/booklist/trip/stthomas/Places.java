package trip.stthomas;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"name", "desc","placeList"} )
public class Places {
	
	private String name;
	private String desc;
	
	@XmlElementWrapper(name="placeList")
	@XmlElement(name="place")
	private ArrayList<Place> placeList;

	public Places() {
		super();
		name = "St Thomas Way";
		desc = "Find more at https://thomasway.ac.uk/explore-the-way/";
		placeList = new ArrayList<Place>();
		createPlaceList();
	}

	private void createPlaceList() {
		Place swansea = new Place(0,"Swansea","Castle","John de Mowbray, Lord of Gower, probably added the arcaded parapet walkway to Swansea Castle in the 1330s.");
		Place margam = new Place(1,"Margam","Abbey Ruins","The Chapter House was where the monks of Margam met to discuss Abbey business.");
		Place ewenny = new Place(2,"Ewenny","Priory Church","Ewenny was shaped by its Benedictine Priory in the Middle Ages, founded in the early twelfth century.");
		Place llancarfan = new Place(3,"Llancarfan","St Cadocs Church","The treasures of Llancarfan include the stunning wall paintings in St Cadoc’s Church, which give a glimpse into the medieval imagination");
		Place stfagans = new Place(4, "St Fagans", "Welsh Museum","In St Fagans, you can walk through hundreds of years of Welsh history");
		Place caerfilly = new Place(5,"Caerfilly","Castle","Set in its huge artificial lakes and mighty walls, Caerphilly Castle tells the story of conflicts and rivalries in the medieval March of Wales.");
		Place newport = new Place(6, "Newport", "St Woolos Cathedral","On the banks of the River Usk, stories of water and wonder flow through the medieval history of Newport.");
		Place usk = new Place(7, "Usk","Priory Church","This picturesque town, with its castle, medieval Priory Church and bridge over the River Usk, is a good place to start.");
		Place abergavenny = new Place(8, "Abergavenny","St Marys Cathedral","Cradled among mountains, the border town of Abergavenny brings you face to face with the medieval past.");
		Place patrishow = new Place(9,"Patrishow","St Issui Church","A place set apart from the world, an ancient church and a holy well.");
		Place longtown = new Place(10,"Longtown","Castle Ruins","One of the lesser-known gems on the St Thomas Way, Longtown village and castle lie amid the awe-inspiring landscape of the Black Mountains.");
		Place kilpeck = new Place(11,"Kilpeck","Church"," church with strange and beautiful carvings, a ruined castle and a lost village: Kilpeck is a place of story-telling, remembering, and forgetting.");
		Place hereford = new Place(12,"Hereford","Cathedral","Hereford’s magnificent cathedral is the culmination of the St Thomas Way, and was journey’s end for William Cragh and thousands of other medieval pilgrims.");
		
		placeList.add(0, swansea);
		placeList.add(1, margam);
		placeList.add(2, ewenny);
		placeList.add(3, llancarfan);
		placeList.add(4, stfagans);
		placeList.add(5, caerfilly);
		placeList.add(6, newport);
		placeList.add(7, usk);
		placeList.add(8, abergavenny);
		placeList.add(9, patrishow);
		placeList.add(10, longtown);
		placeList.add(11, kilpeck);
		placeList.add(12, hereford);
		
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	

	/**
	 * @return the placeList
	 */
	public ArrayList<Place> getPlaceList() {
		return placeList;
	}

	
	

}
