package my.web.serv;

import javax.xml.ws.Endpoint;

/**
 * Example taken from the book Java Web Services (Up and Running)
 * Instead of using any web server to deploy the services,
 * we are using the java code only approach to test the services
 * If you want to deploy it in a specific web server you need to 
 * use their appropriate servlets/launcher code to launch your service.
 * @author Martin Kalin
 *
 */

class TeamsPublisher {
	public static void main(String[] args) {
		int port = 8888;
		String url = "http://localhost:" + port + "/teams";
		System.out.println("Publishing Teams on port " + port);
		Endpoint.publish(url, new Teams());
	}
}