import HelloApp.*;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

/**
 * This is the actual implementation of the Hello Interface.
 * This should be extending from HelloPOA object
 * which in turn is an instane of the Servant class
 * If we want to extend it from another class then 
 * use the Tie model as given in the following guide
 * https://www.jacorb.org/releases/3.9/ProgrammingGuide.pdf
 * @author rama_swuni
 */
public class HelloImpl extends HelloPOA {

	/**
	 * This is the actual implementation of the interface method
	 * @return Hello World in English
	 */
	public String sayHello() {
		return "Hello world!";
	}

}
