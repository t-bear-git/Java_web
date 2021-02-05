package skanetrafikenAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ParseXML {
	
	/**
	 * Returns XML from URL making HTTP request. Can take any valid URL.
	 * Saves response to String.
	 * */
	public String getXmlFromUrl(String url) {

		// String to temp save each line in the response
		String inputLine;
		// String to save the full response to use later
		String ApiResponse = null;
		try {
			// Set the URL that will be sent
			URL line_api_url = new URL(url);

			// Create a HTTP connection to sent the GET request over
			HttpURLConnection linec = (HttpURLConnection) line_api_url.openConnection();
			linec.setDoInput(true);
			linec.setDoOutput(true);
			linec.setRequestMethod("GET");

			// Make a Buffer to read the response from the API
			BufferedReader in = new BufferedReader(new InputStreamReader(linec.getInputStream()));
			ApiResponse = "";

			// loop through the whole response
			while ((inputLine = in.readLine()) != null) {

				// Save the temp line into the full response
				ApiResponse += inputLine;

			}
			in.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ApiResponse;
	}
	
	/**
	 * Getting XML DOM element
	 * This method checks so it is valid xml and converts the XML to elements so methods 
	 * for finding elements and values can be used.
	 * */
	public Document convertStringToXMLDocument(String xmlString) {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder = null;

		try {
			builder = factory.newDocumentBuilder();

			Document doc = builder.parse(new InputSource(new StringReader(xmlString)));

			return doc;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	// Getting xml node value
	public String getValue(Element item, String str) {
		NodeList n = item.getElementsByTagName(str);
		return this.getElementValue(n.item(0));
	}

	// Getting xml node value
	public final String getElementValue(Node elem) {
		Node child;
		if (elem != null) {
			if (elem.hasChildNodes()) {
				for (child = elem.getFirstChild(); child != null; child = child.getNextSibling()) {
					if (child.getNodeType() == Node.TEXT_NODE) {
						return child.getNodeValue();
					}
				}
			}
		}
		return "";
	}

	
}
