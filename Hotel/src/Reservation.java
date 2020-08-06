import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Reservation {
	Scanner in = new Scanner(System.in);
	RoomManager romanager = RoomManager.getInstance(); // �̱��� ���� RoomManager
	MemberManager memmanager = MemberManager.getInstance();  // �̱��� ���� MeberManager
	Guest guest = new Guest(null, null, 0, 0);  // ��ü ����
	LinkedList<Guest> guestlist = new LinkedList<>();  // �����迭
	String name;  // ȸ�� �̸�
	
	public void res() {  // ȸ�� ã��
		boolean fou = false;  // ȸ�� ����
		while(true) {
			System.out.print("ȸ�� �̸� : ");
			name = in.next();
			for (int i=0; i<memmanager.memberlist.size(); i++) {
				if (memmanager.memberlist.get(i).containsKey(name)) {  // name�� member�� key�� ���ٸ�
					fou = true;
					reservation();
					break;
				}
				else System.out.print("��ϵ� ȸ���� �ƴմϴ�.");
			}
			break;
		}
	}
	public void reservation() {  // �� �����ϱ�
		for (int i=0; i<memmanager.memberlist.size(); i++) {
			if (memmanager.memberlist.get(i).containsKey(name)) {  // member�� key�� name ������
				Member val = memmanager.memberlist.get(i).get(name);
			}
		}
			Member rono = memmanager.member.get(name);
			int cnt  = rono.getPeople();  // ȸ�� ���� �ο� ��
				System.out.print("****�ӹ��� �� �ִ� �� ���****\n");
				for (int i=0; i<romanager.roomlist.size(); i++) {
					if(rono.getPeople() <= romanager.roomlist.get(i).getPeople()) {  // ���� �ο� ������ ū �� �����ֱ�
						if (romanager.roomlist.get(i) instanceof SweetRoom) ((SweetRoom) romanager.roomlist.get(i)).show();  // romanager.roomlist.get(i)�� ��ü�� SweetRoom�̸�
						else if (romanager.roomlist.get(i) instanceof DeluxeRoom) ((DeluxeRoom) romanager.roomlist.get(i)).show();  // romanager.roomlist.get(i)�� ��ü�� DeluxeRoom�̸�
						else if (romanager.roomlist.get(i) instanceof StandardRoom) ((StandardRoom) romanager.roomlist.get(i)).show();  // romanager.roomlist.get(i)�� ��ü�� StandardRoom�̸�
					}
				}
				while(true) {
					String house = "0";  // �� ����
					System.out.print("�����Ͻ� �� ��ȣ : ");
					int no = in.nextInt();
					for(int j=0; j<romanager.roomlist.size(); j++) {
						if (romanager.roomlist.get(j).getNo() == no) {
							String sold ="sold";  
							if (romanager.roomlist.get(j).getState().equals(sold)) {  // ������ ���� ���̸�
								System.out.print("���� �Ǿ����ϴ�.\n");
								romanager.roomlist.get(j).setState("sold_out");  // state�� sold -> sold_out���� ����
								if(romanager.roomlist.get(j) instanceof SweetRoom) house = "Sweetroom";   // romanager.roomlist.get(j)�� ��ü�� SweetRoom�̸�
								if(romanager.roomlist.get(j) instanceof DeluxeRoom) house = "Deluxeroom";  // romanager.roomlist.get(j)�� ��ü�� DeluxeRoom�̸�
								if(romanager.roomlist.get(j) instanceof StandardRoom) house = "Standardroom";  // romanager.roomlist.get(j)�� ��ü�� StandardRoom�̸�
								guest = new Guest(name, house, no, cnt);
								guestlist.addLast(guest);  // guestlist�� guest �߰�
								break;
							}
							else System.out.print("������ �Ϸ�� ���Դϴ�.\n");  // state�� sold_out�̸�
						} 
					}break;
				}
			}

	public void guestshow() {  // ���� �� �����ֱ�
		for (Guest g : guestlist)  // foreach
			g.show();
	}
	public void guestfind() {  // ���� �� �˻�
		System.out.print("ã���� ȸ�� �̸� : ");
		String name = in.next();
		for (int i=0; i<guestlist.size(); i++) {
			if (guestlist.get(i).getName().equals(name)) {
				guestlist.get(i).show();  // ã�� ���� ���
				break;
			}
		}
	}
	public void guestdel() {  // ���� �� ���
		System.out.print("���� ����Ͻ� ȸ�� �̸� : ");
		String name = in.next();
		int room = 0;
		for (int i=0; i<guestlist.size(); i++) {
			if (guestlist.get(i).getName().equals(name)) {
				room = guestlist.get(i).getNo();
				guestlist.remove(i);  // guestlist���� ����
				System.out.print("������ ��ҵǾ����ϴ�.\n");
			}
		}
		for (int i=0; i<romanager.roomlist.size(); i++) {
			if (romanager.roomlist.get(i).getNo()==room) {
				romanager.roomlist.get(i).setState("sold");  // ��ҵ� �� state�� sold_out -> sold�� ����
			}
		}
	}
	public void guestsave(String filename) {  // ���� �� ����
		FileWriter writer;
		try {
			writer = new FileWriter(filename);
			BufferedWriter buf = new BufferedWriter(writer);
			for(int i=0; i<guestlist.size();i++) {
				buf.write(guestlist.get(i).getName() + "(");
				buf.write(guestlist.get(i).getCnt() + "��) : ");
				buf.write(guestlist.get(i).getHouse() + " - ");
				buf.write(guestlist.get(i).getNo() + "ȣ ");
				buf.newLine();
			}
			buf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("������ �Ϸ��߽��ϴ�.\n");
	}
}
