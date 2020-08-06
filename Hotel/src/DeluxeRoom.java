import java.util.Scanner;

public class DeluxeRoom  extends Room implements RoomAdm{ // 부모 클래스 Room 상속, RoomAdm 인터페이스
	Scanner in = new Scanner(System.in);
	private String benefit;  // 혜택
	public DeluxeRoom(String state, int no, int people, String bene) {  // 부모 클래스 Room 상속
		super(state, no, people);
		benefit = bene;
	}
	public String getBenefit() {
		return benefit;
	}

	public void setBenefit(String benefit) {
		this.benefit = benefit;
	}

	@Override  // 인터페이스 메소드
	public void show() {  // 방 정보
		System.out.println("[" + state +"] DeluxeRoom (" + no + "호) : " + people + "명 / 혜택  : " + benefit);
	}
	@Override  // 인터페이스 메소드
	public void revise() {  // 혜택 수정
		System.out.print("***혜택 목록***\n");
		System.out.println(benefit);
		System.out.print("수정된 혜택 내용 : ");
		benefit = in.next();
		System.out.print("수정이 완료되었습니다.\n");
		show();
	}
}
