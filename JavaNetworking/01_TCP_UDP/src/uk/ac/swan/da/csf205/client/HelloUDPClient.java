/**
 * A Simple Java UDP Client Server Program 
 * These are used for illustrating how the client server works for CSF205
 * Certain inputs are hardcoded for ease of use. 
 * You can modify them as you wish.
 * This program is purposefully done with threads to 
 * illustrate the fact that it can be done so too. 
 */
package uk.ac.swan.da.csf205.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


/**
 * This is the UDP Client code that sends a language in which
 * it wants the word "hello" in and it doesn't actually wait, it 
 * can go on about its business and when the server sends the datapacket
 * it will read it.
 * @author rvaidhiy
 *
 */
public class HelloUDPClient {

	/**
	 * @param args
	 * @throws SocketException
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) {
		//Create a datagram socket to send the datagram packet
		//the packet will have the information as to which host 
		//and port it needs to be sent to
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket();
			byte[] buf = new byte[256];
			//currently hardcoding it to the localhost
			//you can modify this to make it a user input
			//the same goes for the port (although this is the server port)
			InetAddress ipAddress = InetAddress.getByName("127.0.0.1");
			buf = "Spanish".getBytes();
			//create a datagram packet with the language of your choice
			//and then send the packet via the socket
			DatagramPacket packet = new DatagramPacket(buf,buf.length,ipAddress,2929);
			socket.send(packet);
			
			//then create a datagram packet and use the socket to receive it 
			//and read the datapacket. The byte array associated with packet
			//is recreated everytime to ensure that any remaining data from 
			//the prev request/response is flushed correctly
			buf = new byte[256];
			packet = new DatagramPacket(buf,buf.length);
			socket.receive(packet);
			System.out.println(new String(packet.getData()).trim());
			//just repeating the sequence for more than one language now
			buf = new byte[256];
			buf = "Welsh".getBytes();
			packet = new DatagramPacket(buf,buf.length,ipAddress,2929);
			socket.send(packet);

			buf = new byte[256];
			packet = new DatagramPacket(buf,buf.length);
			socket.receive(packet);
			System.out.println(new String(packet.getData()).trim());
			
			buf = new byte[256];
			buf = "Rubbish".getBytes();
			packet = new DatagramPacket(buf,buf.length,ipAddress,2929);
			socket.send(packet);

			buf = new byte[256];
			packet = new DatagramPacket(buf,buf.length);
			socket.receive(packet);
			System.out.println(new String(packet.getData()).trim());
			
		} catch (IOException e) {
			//bad programming this: but since this program is only for
			//illustration purposes sending these error messages through 
			//the black hole (the console)
			System.out.println(e.getMessage());
		}finally {
			//just trying to close the socket when all else is done and dusted
			if(null!=socket)
			{
				socket.close();
			}
		}

	}

}
