package my.web.serv;

/**
 * Example taken from the book Java Web Services (Up and Running)
 * This class identifies each player in a team.
 * @author Martin Kalin
 *
 */
public class Player {
	private String name;
	private String nickname;

	public Player() {
	}

	public Player(String name, String nickname) {
		setName(name);
		setNickname(nickname);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}
}
