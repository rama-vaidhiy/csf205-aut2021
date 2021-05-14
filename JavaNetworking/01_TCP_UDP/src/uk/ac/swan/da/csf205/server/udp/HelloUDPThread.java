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
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * This is the actual implementation of the
 * UDP Server code that accepts an input datapacket
 * and then checks the language that the client has set
 * and send the response datapacket which contains the word 
 * hello in that language.
 * There are not streams in UDP, it is asynchronous and works
 * with data packets which are of a specific size (256 bytes)
 * in our example.
 * In UDP, both server and client will have their own ports
 * that is why while sending back the response the server need to
 * check the port that was set in the packet sent by the client
 * and respond to that port.
 * @author rvaidhiy
 *
 */
public class HelloUDPThread extends Thread {

	
	private DatagramSocket socket = null;
	private boolean keepRunning = true;
	public HelloUDPThread() throws IOException
	{
		this("HelloThread");
	}
	
	public HelloUDPThread(String name) throws IOException
	{
		//Create a server socket which is a datagram socket
		//and assign a port to it
		//it is hardcoded here for ease of use
		//you can also accept this as input when you start the server
		socket = new DatagramSocket(2929);

	}
	
	@Override
	public void run() {
		System.out.println("Server ready and waiting for client requests");
		while(keepRunning)
		{
			//the keepRunning is flag which you can set it later to stop the server
			//for now it is used to just keep the server thread running forever
			//until it is killed
			byte[] buf = new byte[256];
			// receive request using the datapacket
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
				socket.receive(packet);
				//read the data from the datapacket
				String inputLang = new String(packet.getData()).trim();
				System.out.println("\n"+inputLang);
				//Get the ipaddress of the sender and their port
				InetAddress address = packet.getAddress();
                int port = packet.getPort();
                switch(inputLang)
                {
                case "Spanish":
                	buf = "Hola!".trim().getBytes();
                	break;
                case "Welsh":
                	buf = "Shwmae!".trim().getBytes();
                	break;
                case "Tamil":
                	buf = "Vanakkam!".trim().getBytes();
                	break;
                default:
                	buf = "Hello!".trim().getBytes();
                	
                }
                System.out.println("sending back " +new String(buf));
                //create a datapacket with the sender's/client's ipaddress, port
                //and the response in the language of client's choice
                packet = new DatagramPacket(buf, buf.length, address, port);
                //send the datapacket
                socket.send(packet);
                
				
			} catch (IOException e) {
				//bad programming this: but since this program is only for
				//illustration purposes sending these error messages through 
				//the black hole (the console)
				e.printStackTrace();
			}
		}
		//when you do finally come out of the thread loop close the socket
		//you can also do it in a finally codeblock
		socket.close();
	}
	
	
	

}
