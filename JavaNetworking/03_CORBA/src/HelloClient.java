import org.omg.CosNaming.*;
import HelloApp.*;
import java.io.*;

/**
 * This is the CORBA Client which calls in the provided interface
 * @author rama_swuni
 */
public class HelloClient {
	public static void main(String[] args) throws Exception {
		Hello hello;
		//After initializing the ORB, the client needs to 
		//obtain a reference to the Hello service
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
		//Again this is the simplest way to get the reference
		//to the service without using a NamingService
		//We use the file that was created by Server
		//and the code reads the IOR argument passed to the Client
		BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		//The argument to the resolve operation is, again, 
		//a string that is converted to a Name. 
		//The result is an object reference of type org.omg.CORBA.Object 
		//which has to be narrowed to the type we are expecting, i.e. Hello.
		hello = HelloHelper.narrow(orb.string_to_object(reader.readLine()));
		//now you have got the Hello service at your service 
		//you can call its methods
		System.out.println(hello.sayHello());
		//once done, shutdown the ORB
		orb.shutdown(true);
		System.out.println("done. ");
	}

}
