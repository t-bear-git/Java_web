package skanetrafikenAPI;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

// Class to handle all information for individual stations.
public class Station {

	private String stationNbr;
	private String stationName;
	private double latitude; // X coordinate, RT90
	private double longitude; // Y coordinate, RT90

	public Station(String stationNbr) {
		this.stationNbr = stationNbr;
	}

	public Station(String stationName, String stationNbr) {
		this.stationName = stationName;
		this.stationNbr = stationNbr;
	}

	public Station(String stationName, String stationNbr, String latitude, String longitude) {
		this.stationName = stationName;
		this.stationNbr = stationNbr;
		try {
			this.latitude = Double.parseDouble(latitude);
			this.longitude = Double.parseDouble(longitude);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getStationNbr() {
		return stationNbr;
	}

	public String getStationName() {
		return stationName;
	}
	
	// Method that handle the station call to Skånetrafiken API and handles the information.
	public List<Station> getStationsFromURL(String searchInput) {
		List<Station> foundStations = new ArrayList<Station>();
		String name;
		String x;
		String y;
		String id;
		ParseXML parser = new ParseXML();
		String xmlFromUrl = parser.getXmlFromUrl(ControllerServlet.BaseURL + searchInput);
		if (xmlFromUrl != null) {
			Document doc = parser.convertStringToXMLDocument(xmlFromUrl); // getting DOM element
			NodeList nl = doc.getElementsByTagName("Point");
			for (int i = 0; i < 15; i++) {
				Element e = (Element) nl.item(i);
				name = parser.getValue(e, "Name");
				id = parser.getValue(e, "Id");
				x = parser.getValue(e, "X");
				y = parser.getValue(e, "Y");
				foundStations.add(new Station(name, id, x, y));
			}
		}
		return foundStations;
	}
	@Override
	public String toString() {
		return stationName;
	}
	
	
}
