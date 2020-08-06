import java.util.Scanner;

public class SweetRoom extends Room implements RoomAdm{  // 부모 클래스 Room 상속, RoomAdm 인터페이스
	Scanner in = new Scanner(System.in);
	private String benefit1, benefit2;  // 혜택 2개
	public SweetRoom(String state, int no, int people, String ben1, String ben2) { // 부모클래스 Room 상속
		super(state, no, people);
		benefit1 = ben1;
		benefit2 = ben2;
	}
	public String getBenefit1() {
		return benefit1;
	}

	public void setBenefit1(String benefit1) {
		this.benefit1 = benefit1;
	}

	public String getBenefit2() {
		return benefit2;
	}

	public void setBenefit2(String benefit2) {
		this.benefit2 = benefit2;
	}

	@Override  // 인터페이스 메소드
	public void show() {  // 방 정보
		System.out.println("[" + state + "] SweetRoom (" + no + "호) : " + people + "명 / 혜택  : " + benefit1 +", " + benefit2);
	}
	@Override  // 인터페이스 메소드
	public void revise() {  // 혜택 수정
		System.out.print("***혜택 목록***\n");
		System.out.println("1 : " + benefit1);
		System.out.println("2 : " + benefit2 + "\n");
		System.out.print("수정할 혜택 개수 : ");
		int n = in.nextInt();
		if (n==1) {
			System.out.print("수정할 번호 : ");
			int r = in.nextInt();
			if (r==1) {  // 혜택 하나 수정
				System.out.print("수정된 혜택 내용 : ");
				benefit1 = in.next();
			}
			else if (r==2) {
				System.out.print("수정된 혜택 내용 : ");
				benefit2 = in.next();
			}
		}
		if (n==2) {  // 혜택 전체 수정
			System.out.print("수정된 혜택 내용 : ");
			benefit1 = in.next();
			System.out.print("수정된 혜택 내용 : ");
			benefit2 = in.next();
		}
		System.out.print("수정이 완료되었습니다.\n");
		show();
	}

}
