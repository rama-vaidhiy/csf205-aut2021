import uk.swan.ac.da.csf205.soap.*;

public class HelloClient
{

	public static void main(String[] args) throws Exception
	{
		HelloService hs = new HelloService();
		Hello hello = hs.getHello();
		System.out.println("Response from Service: " +hello.sayHello());
	}
}
