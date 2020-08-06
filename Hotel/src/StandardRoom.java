
public class StandardRoom extends Room implements RoomAdm{ // 부모 클래스 Room 상속, RoomAdm 인터페이스

	public StandardRoom(String state, int no, int people) {  // 부모 클래스 Room 상속
		super(state, no, people);
	}

	@Override  // 인터페이스 메소드
	public void show() {  // 방 정보
		System.out.println("[" + state + "] StandardRoom (" + no + "호) : " + people + "명 ");
	}
	
	
}
