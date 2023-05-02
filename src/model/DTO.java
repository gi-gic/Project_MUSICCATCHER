package model;

public class DTO {

	//

	public DTO(String id, String pw, String nick) {
		super();
		this.id = id;
		this.pw = pw;
		this.nick = nick;
	}

	public DTO(String nick) {
		super();

		this.nick = nick;
	}

	public DTO(String nick, int score, String rankdate) {
		super();
		this.nick = nick;
		this.score = score;
		this.rankdate = rankdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getRankdate() {
		return rankdate;
	}

	public void setRankdate(String rankdate) {
		this.rankdate = rankdate;
	}

	private String id;
	private String pw;
	private String nick;
	private int score;
	private String rankdate;
}
