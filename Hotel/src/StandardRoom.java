
public class StandardRoom extends Room implements RoomAdm{ // �θ� Ŭ���� Room ���, RoomAdm �������̽�

	public StandardRoom(String state, int no, int people) {  // �θ� Ŭ���� Room ���
		super(state, no, people);
	}

	@Override  // �������̽� �޼ҵ�
	public void show() {  // �� ����
		System.out.println("[" + state + "] StandardRoom (" + no + "ȣ) : " + people + "�� ");
	}
	
	
}
