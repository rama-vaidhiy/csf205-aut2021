import org.omg.CosNaming.*;
import HelloApp.*;
import java.io.*;


public class HelloClient
{
	public static void main(String[] args) throws Exception
	{
		Hello hello;
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
		BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		hello = HelloHelper.narrow(orb.string_to_object(reader.readLine()));
		System.out.println(hello.sayHello());
		orb.shutdown(true);
     		System.out.println("done. ");
	}


}
