import java.util.Scanner;

public class DeluxeRoom  extends Room implements RoomAdm{ // �θ� Ŭ���� Room ���, RoomAdm �������̽�
	Scanner in = new Scanner(System.in);
	private String benefit;  // ����
	public DeluxeRoom(String state, int no, int people, String bene) {  // �θ� Ŭ���� Room ���
		super(state, no, people);
		benefit = bene;
	}
	public String getBenefit() {
		return benefit;
	}

	public void setBenefit(String benefit) {
		this.benefit = benefit;
	}

	@Override  // �������̽� �޼ҵ�
	public void show() {  // �� ����
		System.out.println("[" + state +"] DeluxeRoom (" + no + "ȣ) : " + people + "�� / ����  : " + benefit);
	}
	@Override  // �������̽� �޼ҵ�
	public void revise() {  // ���� ����
		System.out.print("***���� ���***\n");
		System.out.println(benefit);
		System.out.print("������ ���� ���� : ");
		benefit = in.next();
		System.out.print("������ �Ϸ�Ǿ����ϴ�.\n");
		show();
	}
}
