package my.web.serv;

import java.util.List;

/**
 * Example taken from the book Java Web Services (Up and Running)
 * This class identifies each Team.
 * Each team consists of one or more players and has a team name.
 * @author Martin Kalin
 *
 */
public class Team {
	
	private List<Player> players;
	private String name;

	public Team() {
	}

	public Team(String name, List<Player> players) {
		setName(name);
		setPlayers(players);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setRosterCount(int n) {
	} //no-op but needed for property

	public int getRosterCount() {
		return (players == null) ? 0 : players.size();
	}

}
