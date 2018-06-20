package Mini_Game_Heaven;


public class MemberDTO {

	private String id;
	private String pw;
	private int score1, score2, score4;
	private Double score3;
	
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

	public int getScore1() {
		return score1;
	}

	public void setScore1(int score1) {
		this.score1 = score1;
	}

	public int getScore2() {
		return score2;
	}

	public void setScore2(int score2) {
		this.score2 = score2;
	}

	public int getScore4() {
		return score4;
	}

	public void setScore4(int score4) {
		this.score4 = score4;
	}

	public Double getScore3() {
		return score3;
	}

	public void setScore3(Double score3) {
		this.score3 = score3;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", score1=" + score1 + ", score2=" + score2 + ", score3=" + score3
				+ ", score4=" + score4 + "]";
	}
	
}
