package uk.ac.swan.da.csf205.server.impl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import uk.ac.swan.da.csf205.server.Hello;
import uk.ac.swan.da.csf205.server.Hello.LANG;

/**
 * The class which implements the RMI interface defined
 * @author rama_swuni
 */
public class HelloServer implements Hello {

	/**
	 * The actual implementation of the RMI interface
	 * @return String saying hello in English
	 */
	@Override
	public String sayHello() throws RemoteException {
		return "Hello!";
	}
	/**
	 * The actual implementation of the RMI interface
	 * @return String saying hello in different languages
	 */
	@Override
	public String sayHello(LANG language) throws RemoteException {
		switch(language)
		{
		case WELSH:
			return "Shwmae!";
		case SPANISH:
			return "Hola!";
		case TAMIL:
			return "Vanakkam!";
		default:
			throw new RemoteException("Invalid Argument");
		}
	}

	public static void main(String[] args)
	{
		try
		{
			//Setting this inorder to ensure that the TCP connection goes through (else you will have connection refused error)
			//System.setProperty("java.rmi.server.hostname", "xxx.xxx.xxx.xxx");
			//Create an instance of the implementation class
			HelloServer hs = new HelloServer();
			//Export that implementation instance to the Java RMI runtime environment
			//this needs to be done to enable the incoming calls to be received by the environment
			Hello stub = (Hello)UnicastRemoteObject.exportObject(hs, 0);
			//Bind the remote object's stub in the registry
			//instead of just doing LocateRegistry.getRegistry() which uses local host with default port of 1099.
			//just to ensure that we are using our custom port. 
			//if you do this then you dont need to start the rmiregistry program manually, because this will do it for you
			//but if you are getting a registry then you need to start the rmiregistry manually and let it run in the
			//background
			Registry registry = LocateRegistry.createRegistry(1919);
			//now bind the exported stub to a name
			registry.bind("Hello", stub);
			//just printing this out to let the user know that something is happening at the server end
			System.out.println("Ready to accept service requests");
			
		}catch(Exception e)
		{
			//bad programming this, but its ok for demonstration purposes. 
			//in your labs and courseworks make sure to handle the exceptions appropriately
			e.printStackTrace(System.out);
			
		}
	}

}
