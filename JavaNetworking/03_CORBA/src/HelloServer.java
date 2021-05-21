import java.io.*;
import org.omg.CosNaming.*;

/**
 * This is the CORBA Server class which is implemented using the
 * JACORB implementation.
 * @author rama_swuni
 */
public class HelloServer {

    public static void main(String[] args) throws Exception {
        //create the instance of the ORB (Object Request Broker)
        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
        //Get the reference to the object adapter i.e. the POA
        //but The returned object is an untyped reference of type 
        //CORBA.Object and thus needs to be narrowed to the correct 
        //type using a static method narrow() in the helper class 
        //for the type in question
        org.omg.PortableServer.POA poa = org.omg.PortableServer.POAHelper
                .narrow(orb.resolve_initial_references("RootPOA"));
        //activate the POA because any POA is created in “holding” 
        //state in which it does not process incoming requests
        poa.the_POAManager().activate();
        //POA is in an active state and can now be asked to create 
        //a CORBA object reference from a Java object also know as a Servant
        org.omg.CORBA.Object o = poa.servant_to_reference(new HelloImpl());
        //In order to make the newly created CORBA object accessible, 
        //we have to make its ob- ject reference available.
        //This is the simplest way without using a Naming Service
        //we just write the IOR reference to a file and distribute that
        //this means when you execute this Server code, you have pass in a
        //filename as an input for e.g. java -cp ..... HelloServer /tmp/nsref
        //this file /tmp/nsref will then needs to be provided to the client also
        PrintWriter ps = new PrintWriter(new FileOutputStream(new File(args[0])));
        ps.println(orb.object_to_string(o));
        ps.close();
        //this is merely housekeeping
        if (args.length == 2) {
            File killFile = new File(args[1]);
            while (!killFile.exists()) {
                Thread.sleep(1000);
            }
            //clean the orb
            orb.shutdown(true);
        } else {
            //in this case if this is the first instance, then run the ORB
            //and wait for client requests.
            orb.run();
        }

    }
}
