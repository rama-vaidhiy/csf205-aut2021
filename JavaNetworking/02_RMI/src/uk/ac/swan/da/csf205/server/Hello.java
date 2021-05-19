/**
 * Java RMI Sample Implementation
 */
package uk.ac.swan.da.csf205.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * It just says hello as a Remote Interface
 * @author rama_swuni
 *
 */
public interface Hello extends Remote {
	
	public enum LANG  {WELSH, SPANISH, TAMIL, UNSUPPORTED};

	/**
	 * an interface method which says Hello (in English) 
	 * when implemented
	 * @returns the word Hello
	 * @throws RemoteException
	 */
	 public String sayHello() throws RemoteException;
	 
	 /**
	 * an interface method which says Hello in the requestd language
	 * when implemented
	 * @returns the word Hello in the requested language
	 * @throws RemoteException
	 */
	 public String sayHello(LANG language) throws RemoteException;
}
