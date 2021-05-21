import HelloApp.*;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;


public class HelloImpl extends HelloPOA
{

	public String sayHello()
  	{
    		return "\nHello world!!\n";
    	}

}

