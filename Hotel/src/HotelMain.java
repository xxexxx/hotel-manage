import java.util.Scanner;

public class HotelMain {

	public static void memmenu() {
		System.out.print("\n");
		System.out.print("1. 회원추가\n");
		System.out.print("2. 회원목록\n");
		System.out.print("3. 회원검색\n");
		System.out.print("4. 회원삭제\n");
		System.out.print("5. 회원저장\n");
		System.out.print("0. 종료\n");
		System.out.print(">>");
	}
	public static void roommenu() {
		System.out.print("\n");
		System.out.print("1. 방 추가하기\n");
		System.out.print("2. 방 목록\n");
		System.out.print("3. 방 혜택수정하기\n");
		System.out.print("4. 방 검색\n");
		System.out.print("5. 방 삭제\n");
		System.out.print("6. 방 저장\n");
		System.out.print("0. 종료\n");
		System.out.print(">>");
	}
	public static void resroom() {
		System.out.print("\n");
		System.out.print("1. 방 예약하기\n");
		System.out.print("2. 방 목록\n");
		System.out.print("3. 방 검색\n");
		System.out.print("4. 방 삭제\n");
		System.out.print("5. 방 저장\n");
		System.out.print("0. 종료\n");
		System.out.print(">>");
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		RoomManager roommanager = RoomManager.getInstance();
		MemberManager membermanager = MemberManager.getInstance();
		Reservation res = new Reservation();
		System.out.print("방 관리하기\n");
		
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
		System.out.print("방 관리를 마칩니다.\n");
		
		System.out.print("회원 관리하기 \n");
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
		System.out.print("회원관리를 마칩니다.\n");
		
		System.out.print("방 예약하기\n");
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
		System.out.print("종료되었습니다.");
	}

}
