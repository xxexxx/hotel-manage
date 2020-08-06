import java.util.Scanner;

public class SweetRoom extends Room implements RoomAdm{  // �θ� Ŭ���� Room ���, RoomAdm �������̽�
	Scanner in = new Scanner(System.in);
	private String benefit1, benefit2;  // ���� 2��
	public SweetRoom(String state, int no, int people, String ben1, String ben2) { // �θ�Ŭ���� Room ���
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

	@Override  // �������̽� �޼ҵ�
	public void show() {  // �� ����
		System.out.println("[" + state + "] SweetRoom (" + no + "ȣ) : " + people + "�� / ����  : " + benefit1 +", " + benefit2);
	}
	@Override  // �������̽� �޼ҵ�
	public void revise() {  // ���� ����
		System.out.print("***���� ���***\n");
		System.out.println("1 : " + benefit1);
		System.out.println("2 : " + benefit2 + "\n");
		System.out.print("������ ���� ���� : ");
		int n = in.nextInt();
		if (n==1) {
			System.out.print("������ ��ȣ : ");
			int r = in.nextInt();
			if (r==1) {  // ���� �ϳ� ����
				System.out.print("������ ���� ���� : ");
				benefit1 = in.next();
			}
			else if (r==2) {
				System.out.print("������ ���� ���� : ");
				benefit2 = in.next();
			}
		}
		if (n==2) {  // ���� ��ü ����
			System.out.print("������ ���� ���� : ");
			benefit1 = in.next();
			System.out.print("������ ���� ���� : ");
			benefit2 = in.next();
		}
		System.out.print("������ �Ϸ�Ǿ����ϴ�.\n");
		show();
	}

}
