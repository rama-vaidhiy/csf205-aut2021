/**
 * 
 */
package uk.ac.swan.da.csf205.client;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import uk.ac.swan.da.csf205.server.Hello;

/**
 * @author rama_swuni
 *
 */
public class HelloClient {

	public static void main(String[] args)
	{
		//method A: to use the locateregistry to use the host and port and find the registry and 
		//lookup the service
		//you can get these as user inputs too
		//because you need to know which host is having the server implemented
		//and on which port. For simplicity, the data is hardcoded here
//		String host = "xxx.xxx.xxx.xxx";
		int port = 1919;
		try
		{
			//Registry registry = LocateRegistry.getRegistry(host,port);
			//Hello stub = (Hello)registry.lookup("Hello");
			//or Method B: you can skip all those and just use Naming service to include the
			//localhost or whatever host is hosting the service with port and the service name
			//all in one line
			Hello stub = (Hello) Naming.lookup("rmi://127.0.0.1:"+port+"/Hello");
			System.out.println("Stub says: " +stub.sayHello());
			System.out.println("Stub says: " +stub.sayHello(Hello.LANG.SPANISH));
			System.out.println("Stub says: " +stub.sayHello(Hello.LANG.UNSUPPORTED));			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
}
