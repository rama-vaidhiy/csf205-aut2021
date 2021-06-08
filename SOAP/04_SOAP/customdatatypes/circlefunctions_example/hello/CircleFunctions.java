package hello;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;


@WebService
public class CircleFunctions
{
	public double getArea(double r)
	{
		return java.lang.Math.PI * (r * r);
	}
	public static void main(String[] args)
	{
		Endpoint.publish("http://localhost:8080/WebServiceExample/circlefunctions", new CircleFunctions());
	}

}
