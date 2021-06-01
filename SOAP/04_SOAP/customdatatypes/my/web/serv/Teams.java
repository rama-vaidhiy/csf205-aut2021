package my.web.serv;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;


/**
 * Example taken from the book Java Web Services (Up and Running)
 * This class is the one that exposes the necessary web services.
 * The whole class is identified as WebService and each method 
 * that is exposed from this is identified as the WebMethods. 
 * It internally uses the TeamsUtility to build sample data.
 * It also throws a generic exception (only for demo purposes, use a
 * properly defined custom exception while building a solution) 
 * to demonstrate the Faults in the SOAP response message.
 * @author Martin Kalin
 *
 */

@WebService
public class Teams {
	private TeamsUtility utils;

	public Teams() {
		utils = new TeamsUtility();
		utils.make_test_teams();
	}

	@WebMethod
	public Team getTeam(String name) throws Exception {
		System.out.println("Input: " + utils.getTeams());
		for (Team t : utils.getTeams()) {
			System.out.println(t.getName());
			if (t.getName().equalsIgnoreCase(name)) {
				return utils.getTeam(name);
			}
		}

		throw new Exception("Team not found");

	}

	@WebMethod
	public List<Team> getTeams() {
		return utils.getTeams();
	}
}