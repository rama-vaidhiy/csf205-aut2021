package pojo.rest.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {

	public HelloResource() {
		// TODO Auto-generated constructor stub
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello()
	{
		return "Hello from HelloResource";
	}
	
	@GET
	@Path("/welsh")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHelloinWelsh()
	{
		return "Shwmae from HelloResource";
	}
}
