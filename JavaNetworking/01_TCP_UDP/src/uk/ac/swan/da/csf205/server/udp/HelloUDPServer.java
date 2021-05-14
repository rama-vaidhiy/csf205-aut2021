/**
 * A Simple Java UDP Client Server Program 
 * These are used for illustrating how the client server works for CSF205
 * Certain inputs are hardcoded for ease of use. 
 * You can modify them as you wish.
 * This program is purposefully done with threads to 
 * illustrate the fact that it can be done so too. 
 */
package uk.ac.swan.da.csf205.server.udp;

import java.io.IOException;

/**
 * This is the UDP Server code that starts a thread where
 * the client requests are processed. This is an example of 
 * how to do multithreaded request processing in UDP. 
 * @author rama_swuni
 *
 */
public class HelloUDPServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		new HelloUDPThread().start();

	}

}
