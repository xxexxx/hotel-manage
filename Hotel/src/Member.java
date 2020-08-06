
public class Member {
	private String telno;  // 회원 전화번호
	private int people;  // 인원 수
	
	public Member( String telno, int people) {
		super();
		this.telno = telno;
		this.people = people;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	@Override
	public String toString() {
		return "Member [telno=" + telno + ", people=" + people + "]";
	}
	
}
