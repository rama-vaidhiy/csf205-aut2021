package booklist.main;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

import trip.stthomas.Place;
import trip.stthomas.Places;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class StThomasTripPublish {

	private Places stthomasPlaces;

	public StThomasTripPublish() {
		stthomasPlaces = new Places();
	}

	@WebMethod
	public Places getStThomasWayPlaces() {
		return stthomasPlaces;
	}

	@WebMethod
	public boolean setPlaceVisited(String city) throws Exception {
		for (Place pl : stthomasPlaces.getPlaceList()) {
			if (pl.getCity().equalsIgnoreCase(city)) {
				pl.setVisited(true);
				stthomasPlaces.getPlaceList().set(pl.getId(), pl);
				return true;
			}
		}
		throw new Exception("Place not found");
	}

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9876/stthomasway", new StThomasTripPublish());
		/**
		 * 
		 * Input XML for getting the list of all places
		 * <soapenv:Envelope xmlns:mns="http://main.booklist/" xmlns:soapenv=
		 * "http://schemas.xmlsoap.org/soap/envelope/"> <soapenv:Body>
		 * <mns:getStThomasWayPlaces> </mns:getStThomasWayPlaces> </soapenv:Body>
		 * </soapenv:Envelope>
		 * 
		 * If you want to set any place as visited
		 * <soapenv:Envelope xmlns:mns="http://main.booklist/" xmlns:soapenv=
		 * "http://schemas.xmlsoap.org/soap/envelope/"> <soapenv:Body>
		 * <mns:setPlaceVisited> <arg0>Swansea</arg0>
		 * 
		 * </mns:setPlaceVisited>
		 * 
		 * </soapenv:Body> </soapenv:Envelope>
		 * 
		 * 
		 */

	}

}
