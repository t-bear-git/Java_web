package skanetrafikenAPI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static String BaseURL = "http://www.labs.skanetrafiken.se/v2.2/querystation.asp?inpPointfr=";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Variables to handle input from form.
		String inputString = request.getParameter("inpPointfr");
		// Variable to check HTTP status code.
		int headerStatus = response.getStatus();
		
		// Check if connection is OK.
		if (headerStatus == 200) {
			
			// Creating object to store request attribute.
			Station stationDetails = new Station(inputString);
			// Take user input and makes call to API.
			stationDetails.getStationsFromURL(inputString);
			// Defining attribute name and object to be used with RequestDispatcher.
			request.setAttribute("FoundStations", stationDetails.getStationsFromURL(inputString));
			// Forwarding to resultpage.jsp using RequestDispatcher.
			request.getRequestDispatcher("resultpage.jsp").forward(request, response);
			
		} else {
			System.out.println("HTTP connection error. Please try again later. Status code: "+headerStatus);
		}
		

	}

	

}
