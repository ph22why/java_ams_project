package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.Session;
import dao.SoldierDAO;
import dto.SoldierDTO;

public class ModifySoldierView {
	public ModifySoldierView() {
		Scanner sc = new Scanner(System.in);
		SoldierDAO sdao = new SoldierDAO();
		
		System.out.println("====병사 정보 수정 페이지====");
		System.out.println("검색할 사단 번호 : ");
		int scamp = sc.nextInt();
		ArrayList<SoldierDTO> result = sdao.getList(scamp); // 특정 사단검색 후 그 안의 병사들 목록 출력
		
		System.out.println("===="+scamp+"사단의 병사들====");
		if(result.size() == 0) { // 병사가 있는지 확인 없으면 아래
			System.out.println("등록된 병사가 없습니다.");
		}
		for(SoldierDTO s : result) {
			System.out.printf("%s - %s - %s\n", s.sarmycode, s.sgrade, s.sname); // 형식은 군번 - 이름 으로 출력
		}
		System.out.printf("수정할 병사의 군번을 입력해 주세요 : ");
		sc = new Scanner(System.in);
		String Sarmycode = sc.nextLine();
		if(sdao.checkId(Sarmycode)) {
			System.out.println("수정하려는 정보의 숫자 입력 : ");
			System.out.println("1. 계급\n2. 상태\n3. 사단\n4. 나가기");
			int choice = sc.nextInt();
			if(choice == 4) {
				// 나가기
				System.out.println("메인으로 돌아갑니다.");
			}else if(choice == 1) {
				// 계급변경
				System.out.println("변경할 계급 입력 : ");
				String Ngrade = sc.next();
				System.out.println("변경할 계급이 "+Ngrade+"맞습니까?\n맞으면 숫자\"0\" 틀리면 숫자\"1\"을 입력하세요"); // 계급 변경 재확인
				int Gchoice = sc.nextInt();
				if(Gchoice == 0) {
					if(sdao.modifyGrade(Ngrade, Sarmycode)) { // 변경완료
						System.out.println(Ngrade + "로 변경 완료되었습니다.");
					}else {
						System.out.println("계급 변경 실패입니다.");
					}
				}else if(Gchoice == 1) {
				}else {
					System.out.println("잘못입력하셨습니다.");
				}				
			}else if(choice == 2) {
				// 상태변경
				System.out.println("변경할 상태 입력 : ");
				String Nstate = sc.next();
				System.out.println("변경할 상태가 "+Nstate+"맞습니까?\n맞으면 숫자\"0\" 틀리면 숫자\"1\"을 입력하세요"); // 상태 변경 재확인
				int Gchoice = sc.nextInt();
				if(Gchoice == 0) {
					if(sdao.modifyState(Nstate, Sarmycode)) {
						System.out.println(Nstate + "중으로 상태변경 완료되었습니다.");
					}else {
						System.out.println("상태 변경 실패입니다.");
					}
				}else if(Gchoice == 1) {
				}else {
					System.out.println("잘못입력하셨습니다.");
				}
			}else if(choice == 3) {
				// 사단변경
				System.out.println("변경할 사단 숫자 입력 : ");
				String Scamp = sc.next();
				System.out.println("변경할 사단이 "+Scamp+"사단 맞습니까?\n맞으면 숫자\"0\" 틀리면 숫자\"1\"을 입력하세요"); // 사단 변경 재확인
				int Bchoice = sc.nextInt();
				if(Bchoice == 0) {
					if(sdao.modifyBelong(Scamp, Sarmycode)) {
						System.out.println(Scamp + "사단으로 변경 완료되었습니다. 재 로그인 부탁드립니다");	
					}else {
						System.out.println("사단 변경 실패입니다.");
					}
				}else if(Bchoice == 1) {
				}else {
					System.out.println("잘못입력하셨습니다.");
				}	
			}else {
				System.out.println("잘못입력하셨습니다");
			}
		}else {
			System.out.println("잘못된 군번입니다");
		}
	}
}
