/**
 * Java RMI Sample Implementation
 */
package uk.ac.swan.da.csf205.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * It just says hello
 * @author rvaidhiy
 *
 */
public interface Hello extends Remote {
	
	public enum LANG  {WELSH, SPANISH, TAMIL, UNSUPPORTED};

	/**
	 * an interface method which says Hello (in English) when implemented
	 * @return
	 * @throws RemoteException
	 */
	 public String sayHello() throws RemoteException;
	 
	 public String sayHello(LANG language) throws RemoteException;
}
