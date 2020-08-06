import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RoomManager {
	Scanner in = new Scanner(System.in);
	Room room = new Room(null, 0, 0);  // 객체 생성자
	SweetRoom sroom = new SweetRoom(null, 0, 0, null, null); // 객체 생성자
	DeluxeRoom droom = new DeluxeRoom(null, 0, 0, null);  // 객체 생성자
	StandardRoom stroom = new StandardRoom(null, 0, 0);  // 객체 생성자
	ArrayList<Room> roomlist = new ArrayList<>();  // 동적 배열
	
	private static RoomManager manager;  // RoomManager 싱글톤 패턴
	private RoomManager() {}  // 생성자 호출 제한
	public static RoomManager getInstance() {  // getInstace 메소드 정의
		if (manager == null) manager = new RoomManager();
		return manager;  // 생성한 인스턴스 리턴
	}
	public void add() {  // 방 추가하기
		System.out.print("방을 등록합니다.\n");
		System.out.print("1.스위트룸 2.디럭스룸 3.스탠다드룸  : ");
		int r = in.nextInt();
		if (r==1) {  // 스위트룸 등록
			System.out.print("호수 : ");
			int no = in.nextInt();
			System.out.print("최대 인원 수 : ");
			int cnt = in.nextInt();
			System.out.print("이용가능여부 : ");
			String state = in.next();
			System.out.print("혜택 : ");
			String be1 = in.next();
			System.out.print("혜택 : ");
			String be2 = in.next();
			sroom = new SweetRoom(state, no, cnt, be1, be2);
			roomlist.add(sroom);  // roomlist에 sroom 추가
		}
		else if (r==2) {  // 디럭스룸 등록
			System.out.print("호수 : ");
			int no = in.nextInt();
			System.out.print("최대 인원 수 : ");
			int cnt = in.nextInt();
			System.out.print("이용가능여부 : ");
			String state = in.next();
			System.out.print("혜택 : ");
			String be = in.next();
			droom = new DeluxeRoom(state,no,cnt,be);
			roomlist.add(droom); // roomlist에 droom 추가
		}
		else if (r==3) {  // 스탠다드룸 등록
			System.out.print("호수 : ");
			int no = in.nextInt();
			System.out.print("최대 인원 수 : ");
			int cnt = in.nextInt();
			System.out.print("이용가능여부 : ");
			String state = in.next();
			stroom = new StandardRoom(state,no,cnt);
			roomlist.add(stroom);  // roomlist에 stroom 추가
		}
		System.out.print("방이 등록되었습니다. \n");
	}
	public void show() { // 방 목록 보여주기
		for (int i=0; i<roomlist.size(); i++) {
			if (roomlist.get(i) instanceof SweetRoom) ((SweetRoom) roomlist.get(i)).show();  // 다운캐스팅  //roomlist.get(i)의 객체가 SweetRoom이면 
			else if (roomlist.get(i) instanceof DeluxeRoom) ((DeluxeRoom) roomlist.get(i)).show();  //roomlist.get(i)의 객체가 DeluxeRoom이면
			else if (roomlist.get(i) instanceof StandardRoom) ((StandardRoom) roomlist.get(i)).show();  //roomlist.get(i)의 객체가 StandardRoom이면
		}
	}
	public void revise() {  // 방 혜택 수정하기
		System.out.print("수정할 방 번호 : ");
		int no = in.nextInt();
		for (int i=0; i<roomlist.size(); i++) {
			if (roomlist.get(i).getNo()==no) {
				if (roomlist.get(i) instanceof SweetRoom) ((SweetRoom) roomlist.get(i)).revise();  //roomlist.get(i)의 객체가 SweetRoom이면
				else if (roomlist.get(i) instanceof DeluxeRoom) ((DeluxeRoom) roomlist.get(i)).revise();  //roomlist.get(i)의 객체가 DeluxeRoom이면
				else if (roomlist.get(i) instanceof StandardRoom) System.out.print("수정할 혜택이 없습니다.");  //roomlist.get(i)의 객체가 StandardRoom이면
			}
		}
	}
	public void find() {  // 방 검색하기
		boolean f = false; // 방 유무 확인
		System.out.print("방 번호 : ");
		int no = in.nextInt(); 
		for (int i=0; i<roomlist.size(); i++) {
			if (roomlist.get(i).getNo()==no) {
				f = true;
				if (roomlist.get(i) instanceof SweetRoom) ((SweetRoom) roomlist.get(i)).show();  //roomlist.get(i)의 객체가 SweetRoom이면
				else if (roomlist.get(i) instanceof DeluxeRoom) ((DeluxeRoom) roomlist.get(i)).show();  //roomlist.get(i)의 객체가 DeluxeRoom이면
				else if (roomlist.get(i) instanceof StandardRoom) ((StandardRoom) roomlist.get(i)).show();  //roomlist.get(i)의 객체가 StandardRoom이면
			}
		}
		if (!f)System.out.print("방이 존재하지 않습니다.\n");  //!f = false
	}
	public void del() {  // 방 삭제하기
		boolean del = false; // 방 유무 확인
		System.out.print("삭제할 방 번호 : ");
		int no = in.nextInt();
		for (int i=0; i<roomlist.size(); i++) {
			if (roomlist.get(i).getNo() == no) {
				del = true;
				roomlist.remove(i);  // roomlist에서 삭제
				System.out.print("방이 삭제되었습니다.\n");
				break;
			}
		}
		if (!del) System.out.print("등록된 방이 없습니다.\n");  //!del = false
	}
	public void save(String filename) {
		FileWriter writer;
		try {
			writer = new FileWriter(filename);
			BufferedWriter buf = new BufferedWriter(writer);
			for(int i=0; i<roomlist.size();i++) {
				buf.write("[" + roomlist.get(i).getState() + "] ");
				if (roomlist.get(i) instanceof SweetRoom) buf.write("SweetRoom : ");  //roomlist.get(i)의 객체가 SweetRoom이면
				else if (roomlist.get(i) instanceof DeluxeRoom) buf.write("DeluxeRoom : ");  //roomlist.get(i)의 객체가 DeluxeRoom이면
				else if (roomlist.get(i) instanceof StandardRoom) buf.write("StandardRoom : ");  //roomlist.get(i)의 객체가 StandardRoom이면
				buf.write(roomlist.get(i).getNo() + "호 (");
				buf.write(roomlist.get(i).getPeople() + "명) ");
				if (roomlist.get(i) instanceof SweetRoom) {  //roomlist.get(i)의 객체가 SweetRoom이면
					buf.write ("혜택 : " + ((SweetRoom)roomlist.get(i)).getBenefit1() +"/ ");
					buf.write (((SweetRoom)roomlist.get(i)).getBenefit2());
				}
				else if (roomlist.get(i) instanceof DeluxeRoom) //roomlist.get(i)의 객체가 DeluxeRoom이면
					buf.write ("혜택 : " + ((DeluxeRoom)roomlist.get(i)).getBenefit());
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
