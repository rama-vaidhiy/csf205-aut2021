/**
 * A Simple Java TCP Client Server Program 
 * These are used for illustrating how the client server works for CSF205
 * Certain inputs are hardcoded for ease of use. 
 * You can modify them as you wish.
 * This program is purposefully done without threads to 
 * illustrate the fact that it can be done so too. 
 * If you want you can extend this by creating a thread for the server
 * actions.
 */
package uk.ac.swan.da.csf205.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
/**
 * This is the TCP Client code that sends a language in which
 * it wants the word "hello" in and waits for the appropriate
 * response. Doesn't do anything else. 
 * @author rvaidhiy
 *
 */
public class HelloTCPClient {

	public static void main(String[] args) {
		try {
			//Since this is the client code, we create a 
			//socket with the host ip address and the port 
			//remember you need to know the port you are gonna connect to
			Socket clientSocket = new Socket("127.0.0.1",3939);
			//get the input and the output stream from the socket
			//use the output stream to send the data
			//and the input stream to get the response from the server
			InputStream in = clientSocket.getInputStream();
			OutputStream out = clientSocket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			PrintWriter pr = new PrintWriter(out);
			String inputLine = null;
			String outputLine = "Spanish";
			System.out.println("Sending "+outputLine+" to server");
			//send the data via the output stream and dont forget to flush it
			pr.println(outputLine);
			pr.flush();
			//then read the response via the input stream
			while((inputLine = br.readLine()) != null)
			{
				System.out.println("Response from server: "+inputLine);
			}
			//and once done close the socket
			clientSocket.close();
			
		} catch (IOException e) {
			//bad programming this: but since this program is only for
			//illustration purposes sending these error messages through 
			//the black hole (the console)
			System.out.println(e.getMessage());
		}

	}

}
