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
package uk.ac.swan.da.csf205.server.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This is the TCP Server code that accepts a language in which
 * the client want the word "hello" in and sends the appropriate
 * response. Doesn't do anything else. 
 * @author rama_swuni
 *
 */
public class HelloTCPServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			//Create a Server Socket (this is applicable only for Server code)
			//and assign a port number for this purpose. You can also accept this 
			//as input if you want to. I am just hardcoding it for ease of use
			ServerSocket serverSocket = new ServerSocket(3939);
			System.out.println("Waiting for a client request...");
			//When we call accept we are basically waiting for any client to connect
			//to this server host and port. Its like keeping the door open 
			//for the first customer.
			//when the first client tries to connect, the clientSocket object
			//will be created.
			Socket clientSocket = serverSocket.accept();
			//We get the input and output streams from the socket.
			//input stream is used to read the data that client had provided
			//output stream is used to send the response back to the client
			InputStream in = clientSocket.getInputStream();
			OutputStream out = clientSocket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			PrintWriter pr = new PrintWriter(out);
			String inputLine = null;
			String outputLine = null;
			//for now, I am just reading one line to know 
			//what language they prefer
			//ain't bothered with anything else they send. 
			inputLine = br.readLine();
			if(inputLine!=null){
				System.out.println("Received :"+inputLine);
				 switch(inputLine.trim())
	                {
	                case "Spanish":
	                	outputLine = "Hola!";
	                	break;
	                case "Welsh":
	                	outputLine = "Shwmae!";
	                	break;
	                case "Tamil":
	                	outputLine = "Vanakkam!";
	                	break;
	                default:
	                	outputLine = "Hello!";
	                	
	                }
			}
			System.out.println("Sending back :"+outputLine);
			//once I have decided what the response is i just 
			//send it to the output stream
			//I also flush the stream to ensure that it is send successfully
			pr.println(outputLine);
			pr.flush();
			//I promptly close all the connections once it is done 
			//as this is not a threaded server
			clientSocket.close();
			serverSocket.close();
			
		} catch (IOException e) {
			//bad programming this: but since this program is only for
			//illustration purposes sending these error messages through 
			//the black hole (the console)
			System.out.println(e.getMessage());
		}

	}

}
