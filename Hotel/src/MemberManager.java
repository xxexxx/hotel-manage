import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MemberManager {
	Scanner in = new Scanner(System.in);
	TreeMap<String, Member> member = new TreeMap<>();  
	ArrayList <TreeMap<String, Member>> memberlist = new ArrayList<TreeMap<String, Member>>(); // TreeMap �������� �迭�� ����
	

	private static MemberManager manager;  // MemberManager �̱��� ����
	private MemberManager(){}  // ������ ȣ�� ����
	public static MemberManager getInstance() {   // getInstace �޼ҵ� ����
		if(manager==null) manager = new MemberManager();
		return manager;  // ������ �ν��Ͻ� ����
	}
	public void add() {  // ȸ�� �߰�
		System.out.print("�̸� : ");
		String name = in.next();
		System.out.print("��ȭ��ȣ : ");
		String telno = in.next();
		System.out.print("�ο� �� : ");
		int cnt = in.nextInt();
		member.put(name, new Member(telno, cnt));  // TreeMap<String, Member>
		memberlist.add(member);  // memberlist�� member �߰�
		System.out.print("������ �Ϸ�Ǿ����ϴ�.\n");
	}
	public void show() {  // ȸ�� ���
		Set<String> keys = member.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = (String) it.next();  // Obj -> String
			Member val = member.get(key);  // value ��
			System.out.print("�̸� : " + key + " ��ȭ��ȣ : " + val.getTelno() + " �ο� �� : " + val.getPeople() + "\n");
		}
	}
	public void find() {  // ȸ�� �˻�
		System.out.print("ã���� ȸ�� �̸� : ");
		String name =in.next();
		Member val = member.get(name);
		if(member.containsKey(name))  // member�� key�� name�� ���ٸ�
			System.out.print("�̸� : " + name + " ��ȭ��ȣ : " + val.getTelno() + " �ο� �� : " + val.getPeople());
		else  // member�� key�� name�� �ٸ��ٸ�
			System.out.print("ȸ���� �����ϴ�.\n");
	}
	public void del() {  // ȸ�� ����
		System.out.print("������ ȸ�� �̸� : ");
		String name =in.next();
		if(member.containsKey(name)) { // member�� key�� name�� ���ٸ�
			member.remove(name);  // member�� key�� value ����
			System.out.print("ȸ���� �����Ǿ����ϴ�. \n");
		}
		else System.out.print("ȸ���� ã�� �� �߽��ϴ�.\n");	  // member�� key�� name�� �ٸ���
	}
	public void save(String filename) {  // ���� ����� ����
		FileWriter writer;
		try {
			writer = new FileWriter(filename);
			BufferedWriter buf = new BufferedWriter(writer);
			Set<String> keys = member.keySet();
			Iterator<String> it = keys.iterator();
			while(it.hasNext()) {
				String key =(String) it.next();  // Obj -> String ��ȯ
				Member val = member.get(key);
				buf.write(key+": ");
				buf.write(val.getTelno()+", ");
				buf.write(val.getPeople()+"��");
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