
public class Guest {
	private String name, house;  // ���� ȸ��, ���� ��
	private int no, cnt;  // ���� �� ȣ��, ���� �ο�
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
	public void show() {  // ���� ��Ȳ ����
		System.out.print(name + "(" + cnt + "��) : " + house + " - " + no + "ȣ\n");
	}
	
}
