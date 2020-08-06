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
	ArrayList <TreeMap<String, Member>> memberlist = new ArrayList<TreeMap<String, Member>>(); // TreeMap 형식으로 배열에 저장
	

	private static MemberManager manager;  // MemberManager 싱글톤 패턴
	private MemberManager(){}  // 생성자 호출 제한
	public static MemberManager getInstance() {   // getInstace 메소드 정의
		if(manager==null) manager = new MemberManager();
		return manager;  // 생성한 인스턴스 리턴
	}
	public void add() {  // 회원 추가
		System.out.print("이름 : ");
		String name = in.next();
		System.out.print("전화번호 : ");
		String telno = in.next();
		System.out.print("인원 수 : ");
		int cnt = in.nextInt();
		member.put(name, new Member(telno, cnt));  // TreeMap<String, Member>
		memberlist.add(member);  // memberlist에 member 추가
		System.out.print("가입이 완료되었습니다.\n");
	}
	public void show() {  // 회원 목록
		Set<String> keys = member.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = (String) it.next();  // Obj -> String
			Member val = member.get(key);  // value 값
			System.out.print("이름 : " + key + " 전화번호 : " + val.getTelno() + " 인원 수 : " + val.getPeople() + "\n");
		}
	}
	public void find() {  // 회원 검색
		System.out.print("찾으실 회원 이름 : ");
		String name =in.next();
		Member val = member.get(name);
		if(member.containsKey(name))  // member의 key와 name이 같다면
			System.out.print("이름 : " + name + " 전화번호 : " + val.getTelno() + " 인원 수 : " + val.getPeople());
		else  // member의 key와 name이 다르다면
			System.out.print("회원이 없습니다.\n");
	}
	public void del() {  // 회원 삭제
		System.out.print("삭제할 회원 이름 : ");
		String name =in.next();
		if(member.containsKey(name)) { // member의 key와 name이 같다면
			member.remove(name);  // member의 key와 value 삭제
			System.out.print("회원이 삭제되었습니다. \n");
		}
		else System.out.print("회원을 찾지 못 했습니다.\n");	  // member의 key와 name이 다르면
	}
	public void save(String filename) {  // 파일 입출력 저장
		FileWriter writer;
		try {
			writer = new FileWriter(filename);
			BufferedWriter buf = new BufferedWriter(writer);
			Set<String> keys = member.keySet();
			Iterator<String> it = keys.iterator();
			while(it.hasNext()) {
				String key =(String) it.next();  // Obj -> String 변환
				Member val = member.get(key);
				buf.write(key+": ");
				buf.write(val.getTelno()+", ");
				buf.write(val.getPeople()+"명");
				buf.newLine();
			}
			buf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("저장을 완료했습니다.\n");
	}
}