import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RoomManager {
	Scanner in = new Scanner(System.in);
	Room room = new Room(null, 0, 0);  // ��ü ������
	SweetRoom sroom = new SweetRoom(null, 0, 0, null, null); // ��ü ������
	DeluxeRoom droom = new DeluxeRoom(null, 0, 0, null);  // ��ü ������
	StandardRoom stroom = new StandardRoom(null, 0, 0);  // ��ü ������
	ArrayList<Room> roomlist = new ArrayList<>();  // ���� �迭
	
	private static RoomManager manager;  // RoomManager �̱��� ����
	private RoomManager() {}  // ������ ȣ�� ����
	public static RoomManager getInstance() {  // getInstace �޼ҵ� ����
		if (manager == null) manager = new RoomManager();
		return manager;  // ������ �ν��Ͻ� ����
	}
	public void add() {  // �� �߰��ϱ�
		System.out.print("���� ����մϴ�.\n");
		System.out.print("1.����Ʈ�� 2.�𷰽��� 3.���Ĵٵ��  : ");
		int r = in.nextInt();
		if (r==1) {  // ����Ʈ�� ���
			System.out.print("ȣ�� : ");
			int no = in.nextInt();
			System.out.print("�ִ� �ο� �� : ");
			int cnt = in.nextInt();
			System.out.print("�̿밡�ɿ��� : ");
			String state = in.next();
			System.out.print("���� : ");
			String be1 = in.next();
			System.out.print("���� : ");
			String be2 = in.next();
			sroom = new SweetRoom(state, no, cnt, be1, be2);
			roomlist.add(sroom);  // roomlist�� sroom �߰�
		}
		else if (r==2) {  // �𷰽��� ���
			System.out.print("ȣ�� : ");
			int no = in.nextInt();
			System.out.print("�ִ� �ο� �� : ");
			int cnt = in.nextInt();
			System.out.print("�̿밡�ɿ��� : ");
			String state = in.next();
			System.out.print("���� : ");
			String be = in.next();
			droom = new DeluxeRoom(state,no,cnt,be);
			roomlist.add(droom); // roomlist�� droom �߰�
		}
		else if (r==3) {  // ���Ĵٵ�� ���
			System.out.print("ȣ�� : ");
			int no = in.nextInt();
			System.out.print("�ִ� �ο� �� : ");
			int cnt = in.nextInt();
			System.out.print("�̿밡�ɿ��� : ");
			String state = in.next();
			stroom = new StandardRoom(state,no,cnt);
			roomlist.add(stroom);  // roomlist�� stroom �߰�
		}
		System.out.print("���� ��ϵǾ����ϴ�. \n");
	}
	public void show() { // �� ��� �����ֱ�
		for (int i=0; i<roomlist.size(); i++) {
			if (roomlist.get(i) instanceof SweetRoom) ((SweetRoom) roomlist.get(i)).show();  // �ٿ�ĳ����  //roomlist.get(i)�� ��ü�� SweetRoom�̸� 
			else if (roomlist.get(i) instanceof DeluxeRoom) ((DeluxeRoom) roomlist.get(i)).show();  //roomlist.get(i)�� ��ü�� DeluxeRoom�̸�
			else if (roomlist.get(i) instanceof StandardRoom) ((StandardRoom) roomlist.get(i)).show();  //roomlist.get(i)�� ��ü�� StandardRoom�̸�
		}
	}
	public void revise() {  // �� ���� �����ϱ�
		System.out.print("������ �� ��ȣ : ");
		int no = in.nextInt();
		for (int i=0; i<roomlist.size(); i++) {
			if (roomlist.get(i).getNo()==no) {
				if (roomlist.get(i) instanceof SweetRoom) ((SweetRoom) roomlist.get(i)).revise();  //roomlist.get(i)�� ��ü�� SweetRoom�̸�
				else if (roomlist.get(i) instanceof DeluxeRoom) ((DeluxeRoom) roomlist.get(i)).revise();  //roomlist.get(i)�� ��ü�� DeluxeRoom�̸�
				else if (roomlist.get(i) instanceof StandardRoom) System.out.print("������ ������ �����ϴ�.");  //roomlist.get(i)�� ��ü�� StandardRoom�̸�
			}
		}
	}
	public void find() {  // �� �˻��ϱ�
		boolean f = false; // �� ���� Ȯ��
		System.out.print("�� ��ȣ : ");
		int no = in.nextInt(); 
		for (int i=0; i<roomlist.size(); i++) {
			if (roomlist.get(i).getNo()==no) {
				f = true;
				if (roomlist.get(i) instanceof SweetRoom) ((SweetRoom) roomlist.get(i)).show();  //roomlist.get(i)�� ��ü�� SweetRoom�̸�
				else if (roomlist.get(i) instanceof DeluxeRoom) ((DeluxeRoom) roomlist.get(i)).show();  //roomlist.get(i)�� ��ü�� DeluxeRoom�̸�
				else if (roomlist.get(i) instanceof StandardRoom) ((StandardRoom) roomlist.get(i)).show();  //roomlist.get(i)�� ��ü�� StandardRoom�̸�
			}
		}
		if (!f)System.out.print("���� �������� �ʽ��ϴ�.\n");  //!f = false
	}
	public void del() {  // �� �����ϱ�
		boolean del = false; // �� ���� Ȯ��
		System.out.print("������ �� ��ȣ : ");
		int no = in.nextInt();
		for (int i=0; i<roomlist.size(); i++) {
			if (roomlist.get(i).getNo() == no) {
				del = true;
				roomlist.remove(i);  // roomlist���� ����
				System.out.print("���� �����Ǿ����ϴ�.\n");
				break;
			}
		}
		if (!del) System.out.print("��ϵ� ���� �����ϴ�.\n");  //!del = false
	}
	public void save(String filename) {
		FileWriter writer;
		try {
			writer = new FileWriter(filename);
			BufferedWriter buf = new BufferedWriter(writer);
			for(int i=0; i<roomlist.size();i++) {
				buf.write("[" + roomlist.get(i).getState() + "] ");
				if (roomlist.get(i) instanceof SweetRoom) buf.write("SweetRoom : ");  //roomlist.get(i)�� ��ü�� SweetRoom�̸�
				else if (roomlist.get(i) instanceof DeluxeRoom) buf.write("DeluxeRoom : ");  //roomlist.get(i)�� ��ü�� DeluxeRoom�̸�
				else if (roomlist.get(i) instanceof StandardRoom) buf.write("StandardRoom : ");  //roomlist.get(i)�� ��ü�� StandardRoom�̸�
				buf.write(roomlist.get(i).getNo() + "ȣ (");
				buf.write(roomlist.get(i).getPeople() + "��) ");
				if (roomlist.get(i) instanceof SweetRoom) {  //roomlist.get(i)�� ��ü�� SweetRoom�̸�
					buf.write ("���� : " + ((SweetRoom)roomlist.get(i)).getBenefit1() +"/ ");
					buf.write (((SweetRoom)roomlist.get(i)).getBenefit2());
				}
				else if (roomlist.get(i) instanceof DeluxeRoom) //roomlist.get(i)�� ��ü�� DeluxeRoom�̸�
					buf.write ("���� : " + ((DeluxeRoom)roomlist.get(i)).getBenefit());
				buf.newLine();
			}
			buf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("������ �Ϸ��߽��ϴ�.\n");
	}
}
