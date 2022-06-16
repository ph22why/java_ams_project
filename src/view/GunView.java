package view;

import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.Session;

import dao.GunDAO;
import dao.TransDAO;
import dto.GunDTO;

public class GunView {
	public GunView() {
		GunDAO gdao = new GunDAO();
		TransDAO tdao = new TransDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("------총기관리화면------");
		while(true) {
 			System.out.println("1. 총기 등록");
			System.out.println("2. 총기 조회");
			System.out.println("3. 총기 검색");
			System.out.println("4. 총기 정보 수정");
			System.out.println("5. 총기 반납");
			System.out.println("6. 뒤로가기");	
			int choice = sc.nextInt();
			
			if(choice == 6) {
				//뒤로가기
				break;
			}
			ArrayList<GunDTO> result = null;
			int gunnum = 0;
			switch(choice) {
			case 1:
				//총기 등록
				new AddGunView();
				break;
			case 2:
				//총기 조회
				result = gdao.getList();
				System.out.println("총기 목록");
				if(result.size() == 0) {
					System.out.println("등록된 총기가 없습니다.");
				}
				for (GunDTO g : result) {
					System.out.printf("총기번호 : %d\n총기명  : %s\n",g.gunnum,g.gunname);
				}
				break;
			case 3:
				//총기 검색
				System.out.println("총기명을 입력해주세요");
				sc = new Scanner(System.in);
				String gunname = sc.nextLine();
				result = gdao.search(gunname);
				System.out.println("검색된 총기 목록");
				if(result.size() == 0) {
					System.out.println("검색된 총기가 없습니다.");
				}
				for (GunDTO g : result) {
					System.out.printf("총기번호 : %d\n총기명  : %s\n",g.gunnum,g.gunname);
				}
				break;
			case 4:
				//총기 정보 수정
				result = gdao.getList();
				System.out.println("총기 목록");
				if(result.size() == 0) {
					System.out.println("등록된 총기가 없습니다.");
				}
				for (GunDTO g : result) {
					System.out.printf("총기번호 : %d\n총기명  : %s\n",g.gunnum,g.gunname);
				}
				new ModifyGunView();
				break;
			case 5:
				//총기 반납
				result = gdao.getList();
				System.out.println("총기 목록");
				if(result.size() == 0) {
					System.out.println("등록된 총기가 없습니다.");
				}
				for (GunDTO g : result) {
					System.out.printf("총기번호 : %d\n총기명  : %s\n",g.gunnum,g.gunname);
				}
				System.out.print("반납할 총기의 총기번호 : ");
				gunnum = sc.nextInt();
				int gbnum = 3;
				int amount = 1;
				String gbname = String.valueOf(gunnum);
				if(tdao.send(gbnum, gbname, amount)) {
					if(gdao.removeGun(gunnum)) {
						System.out.println(gunnum+"의 총기가 삭제되었습니다!");
						while(true) {
							int num = tdao.checknum();
							if(num >= 30) {
								if(tdao.empty()) {
									System.out.println("폐기물 처리 완료되었습니다.");		
									break;
								}else {
									break;
								}
							}break;
						}
					}else {
						System.out.println("행삭제실패");
					}
				}else {
					System.out.println("총기 반납 실패 / 다음에 다시 반납해 주세요.");
				}
				break;
			}
		}
	}
}