
public class Guest {
	private String name, house;  // 예약 회원, 예약 방
	private int no, cnt;  // 예약 방 호수, 예약 인원
	public Guest(String name, String house, int no, int cnt) {
		super();
		this.name = name;
		this.house = house;
		this.no = no;
		this.cnt = cnt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public void show() {  // 예약 현황 보기
		System.out.print(name + "(" + cnt + "명) : " + house + " - " + no + "호\n");
	}
	
}
