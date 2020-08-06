import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Reservation {
	Scanner in = new Scanner(System.in);
	RoomManager romanager = RoomManager.getInstance(); // 싱글톤 패턴 RoomManager
	MemberManager memmanager = MemberManager.getInstance();  // 싱글톤 패턴 MeberManager
	Guest guest = new Guest(null, null, 0, 0);  // 객체 생성
	LinkedList<Guest> guestlist = new LinkedList<>();  // 정적배열
	String name;  // 회원 이름
	
	public void res() {  // 회원 찾기
		boolean fou = false;  // 회원 유무
		while(true) {
			System.out.print("회원 이름 : ");
			name = in.next();
			for (int i=0; i<memmanager.memberlist.size(); i++) {
				if (memmanager.memberlist.get(i).containsKey(name)) {  // name이 member의 key와 같다면
					fou = true;
					reservation();
					break;
				}
				else System.out.print("등록된 회원이 아닙니다.");
			}
			break;
		}
	}
	public void reservation() {  // 방 예약하기
		for (int i=0; i<memmanager.memberlist.size(); i++) {
			if (memmanager.memberlist.get(i).containsKey(name)) {  // member의 key와 name 같으면
				Member val = memmanager.memberlist.get(i).get(name);
			}
		}
			Member rono = memmanager.member.get(name);
			int cnt  = rono.getPeople();  // 회원 예약 인원 수
				System.out.print("****머무실 수 있는 방 목록****\n");
				for (int i=0; i<romanager.roomlist.size(); i++) {
					if(rono.getPeople() <= romanager.roomlist.get(i).getPeople()) {  // 예약 인원 수보다 큰 방 보여주기
						if (romanager.roomlist.get(i) instanceof SweetRoom) ((SweetRoom) romanager.roomlist.get(i)).show();  // romanager.roomlist.get(i)의 객체가 SweetRoom이면
						else if (romanager.roomlist.get(i) instanceof DeluxeRoom) ((DeluxeRoom) romanager.roomlist.get(i)).show();  // romanager.roomlist.get(i)의 객체가 DeluxeRoom이면
						else if (romanager.roomlist.get(i) instanceof StandardRoom) ((StandardRoom) romanager.roomlist.get(i)).show();  // romanager.roomlist.get(i)의 객체가 StandardRoom이면
					}
				}
				while(true) {
					String house = "0";  // 방 종류
					System.out.print("예약하실 방 번호 : ");
					int no = in.nextInt();
					for(int j=0; j<romanager.roomlist.size(); j++) {
						if (romanager.roomlist.get(j).getNo() == no) {
							String sold ="sold";  
							if (romanager.roomlist.get(j).getState().equals(sold)) {  // 예약이 없는 방이면
								System.out.print("예약 되었습니다.\n");
								romanager.roomlist.get(j).setState("sold_out");  // state를 sold -> sold_out으로 변경
								if(romanager.roomlist.get(j) instanceof SweetRoom) house = "Sweetroom";   // romanager.roomlist.get(j)의 객체가 SweetRoom이면
								if(romanager.roomlist.get(j) instanceof DeluxeRoom) house = "Deluxeroom";  // romanager.roomlist.get(j)의 객체가 DeluxeRoom이면
								if(romanager.roomlist.get(j) instanceof StandardRoom) house = "Standardroom";  // romanager.roomlist.get(j)의 객체가 StandardRoom이면
								guest = new Guest(name, house, no, cnt);
								guestlist.addLast(guest);  // guestlist에 guest 추가
								break;
							}
							else System.out.print("예약이 완료된 방입니다.\n");  // state가 sold_out이면
						} 
					}break;
				}
			}

	public void guestshow() {  // 예약 방 보여주기
		for (Guest g : guestlist)  // foreach
			g.show();
	}
	public void guestfind() {  // 예약 방 검색
		System.out.print("찾으실 회원 이름 : ");
		String name = in.next();
		for (int i=0; i<guestlist.size(); i++) {
			if (guestlist.get(i).getName().equals(name)) {
				guestlist.get(i).show();  // 찾은 정보 출력
				break;
			}
		}
	}
	public void guestdel() {  // 예약 방 취소
		System.out.print("예약 취소하실 회원 이름 : ");
		String name = in.next();
		int room = 0;
		for (int i=0; i<guestlist.size(); i++) {
			if (guestlist.get(i).getName().equals(name)) {
				room = guestlist.get(i).getNo();
				guestlist.remove(i);  // guestlist에서 삭제
				System.out.print("예약이 취소되었습니다.\n");
			}
		}
		for (int i=0; i<romanager.roomlist.size(); i++) {
			if (romanager.roomlist.get(i).getNo()==room) {
				romanager.roomlist.get(i).setState("sold");  // 취소된 방 state를 sold_out -> sold로 변경
			}
		}
	}
	public void guestsave(String filename) {  // 예약 방 저장
		FileWriter writer;
		try {
			writer = new FileWriter(filename);
			BufferedWriter buf = new BufferedWriter(writer);
			for(int i=0; i<guestlist.size();i++) {
				buf.write(guestlist.get(i).getName() + "(");
				buf.write(guestlist.get(i).getCnt() + "명) : ");
				buf.write(guestlist.get(i).getHouse() + " - ");
				buf.write(guestlist.get(i).getNo() + "호 ");
				buf.newLine();
			}
			buf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("저장을 완료했습니다.\n");
	}
}
