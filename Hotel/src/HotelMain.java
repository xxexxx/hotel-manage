import java.util.Scanner;

public class HotelMain {

	public static void memmenu() {
		System.out.print("\n");
		System.out.print("1. ȸ���߰�\n");
		System.out.print("2. ȸ�����\n");
		System.out.print("3. ȸ���˻�\n");
		System.out.print("4. ȸ������\n");
		System.out.print("5. ȸ������\n");
		System.out.print("0. ����\n");
		System.out.print(">>");
	}
	public static void roommenu() {
		System.out.print("\n");
		System.out.print("1. �� �߰��ϱ�\n");
		System.out.print("2. �� ���\n");
		System.out.print("3. �� ���ü����ϱ�\n");
		System.out.print("4. �� �˻�\n");
		System.out.print("5. �� ����\n");
		System.out.print("6. �� ����\n");
		System.out.print("0. ����\n");
		System.out.print(">>");
	}
	public static void resroom() {
		System.out.print("\n");
		System.out.print("1. �� �����ϱ�\n");
		System.out.print("2. �� ���\n");
		System.out.print("3. �� �˻�\n");
		System.out.print("4. �� ����\n");
		System.out.print("5. �� ����\n");
		System.out.print("0. ����\n");
		System.out.print(">>");
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		RoomManager roommanager = RoomManager.getInstance();
		MemberManager membermanager = MemberManager.getInstance();
		Reservation res = new Reservation();
		System.out.print("�� �����ϱ�\n");
		
		while(true) {
			roommenu();
			int n = in.nextInt();
			if(n==0) break;
			if(n==1) roommanager.add();
			if(n==2) roommanager.show();
			if(n==3) roommanager.revise();
			if(n==4) roommanager.find();
			if(n==5) roommanager.del();
			if(n==6) roommanager.save("roomlist.txt");
		}
		System.out.print("�� ������ ��Ĩ�ϴ�.\n");
		
		System.out.print("ȸ�� �����ϱ� \n");
		while(true) {
			memmenu();
			int n = in.nextInt();
			if (n==0) break;
			if (n==1) membermanager.add();
			if (n==2) membermanager.show();
			if (n==3) membermanager.find();
			if (n==4) membermanager.del();
			if (n==5) membermanager.save("memberlist.txt");
		}
		System.out.print("ȸ�������� ��Ĩ�ϴ�.\n");
		
		System.out.print("�� �����ϱ�\n");
		while(true) {
			resroom();
			int n=in.nextInt();
			if(n==0) break;
			if (n==1) res.res();
			if (n==2) res.guestshow();
			if (n==3) res.guestfind();
			if (n==4) res.guestdel();
			if (n==5) res.guestsave("reservation.txt");
		}
		System.out.print("����Ǿ����ϴ�.");
	}

}
