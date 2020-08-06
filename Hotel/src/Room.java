
public class Room {
	protected String state;  // 방 예약 상태
	protected int no, people;  // 방 호수 , 방 최대 인원
	
	public Room(String state, int no, int people) {
		super();
		this.state = state;
		this.no = no;
		this.people = people;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	
}
