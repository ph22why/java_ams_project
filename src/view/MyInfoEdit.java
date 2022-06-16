package view;

import java.util.Scanner;

import dao.GunDAO;
import dao.ManagerDao;
import dao.Session;
import dto.ManagerDTO;

public class MyInfoEdit {
	public MyInfoEdit() {
		// 모든 내정보 수정은 수정후 자동로그아웃 후 재로그인 필요
		ManagerDao mdao = new ManagerDao();
		GunDAO gdao = new GunDAO();
		ManagerDTO loginManager = (ManagerDTO)Session.getData("loginManager");
		Scanner sc = new Scanner(System.in);
		System.out.println("수정하려는 정보의 숫자 입력 : ");
		System.out.println("1. 비밀번호\n2. 계급\n3. 직책\n4. 이름\n5. 사단번호\n6. 수정취소\n7. 전역신고");
		int choice = sc.nextInt();
		if(choice == 6) {
			//수정취소
			System.out.println("메인으로 돌아갑니다.");
		}else if(choice == 7) {
			// 전역신고
			System.out.print("비밀번호 재입력 : "); // 비밀번호 재입력 받은 후 
			String Mpw = sc.next();
			if(loginManager.Mpassword.equals(Mpw)) { // 맞는지 확인하여 전역시킴
				if(mdao.leaveID(loginManager.MarmyCode)) {
					if(gdao.removeGun(loginManager.Mgunnum)) {
						System.out.println("전역을 축하드립니다!!");
					}else {
						System.out.println("리브아이디 실패");
					}
				}else {
					System.out.println("리무브얼 실패");
				}
			}else {
				System.out.println("비밀번호오류입니다. 확인부탁드립니다.");
			}
		}else if(choice == 1) {
			// 비밀번호 변경
			System.out.println("현재 비밀번호 입력 : ");
			String Mpw = sc.next();
			if(mdao.checkPW(Mpw)) {
				System.out.println("새로운 비밀번호 입력 : ");
				String Npw = sc.next();
				System.out.println("비밀번호 확인 : "); //바꾸는 비밀번호 재확인 작업
				String NNpw = sc.next();
				if(Npw.equals(NNpw)) {	// 재확인
					if(mdao.modifytPW(Npw, loginManager.MarmyCode)) {
						System.out.println("비밀번호 변경에 성공하였습니다. 재 로그인 부탁드립니다."); // 암호 변경 성공
						Session.setData("loginManager", null);
					}else {
						System.out.println("비밀번호 변경 실패입니다.");
					}
				}else {
					System.out.println("새로운 비밀번호가 다릅니다.");	// 재확인 실패
				}
			}else {
				System.out.println("비밀번호가 다릅니다.");
			}
		}else if(choice == 2) {
			// 계급 변경
			System.out.println("변경할 계급 입력 : ");
			String Ngrade = sc.next();
			System.out.println("변경할 계급이 "+Ngrade+"맞습니까?\n맞으면 숫자\"0\" 틀리면 숫자\"1\"을 입력하세요"); // 계급변경 재확인
			int Gchoice = sc.nextInt();
			if(Gchoice == 0) {
				if(mdao.modifyGrade(Ngrade, loginManager.MarmyCode)) {
					System.out.println(Ngrade + "로 변경 완료되었습니다. 재 로그인 부탁드립니다");	//변경 완료
					Session.setData("loginManager", null);
				}else {
					System.out.println("계급 변경 실패입니다.");
				}
			}else if(Gchoice == 1) {
			}else {
				System.out.println("잘못입력하셨습니다.");
			}				
			
		}else if(choice == 3) {
			// 직책 변경
			System.out.println("변경할 직책 입력 : ");
			String Njob = sc.next();
			System.out.println("변경할 직책이 "+Njob+"맞습니까?\n맞으면 숫자\"0\" 틀리면 숫자\"1\"을 입력하세요"); // 직책변경 재확인작업
			int Jchoice = sc.nextInt();
			if(Jchoice == 0) {
				if(mdao.modifyJob(Njob, loginManager.MarmyCode)) {
					System.out.println(Njob + "로 변경 완료되었습니다. 재 로그인 부탁드립니다");	
					Session.setData("loginManager", null);
				}else {
					System.out.println("직책 변경 실패입니다.");
				}
			}else if(Jchoice == 1) {
			}else {
				System.out.println("잘못입력하셨습니다.");
			}			
		}else if(choice == 4) {
			// 이름 변경
			System.out.println("변경할 이름 입력 : ");
			String Nname = sc.next();
			System.out.println("변경할 이름이 "+Nname+"맞습니까?\n맞으면 숫자\"0\" 틀리면 숫자\"1\"을 입력하세요"); // 재확인작업
			int Nchoice = sc.nextInt();
			if(Nchoice == 0) {
				if(mdao.modifyName(Nname, loginManager.MarmyCode)) {
					System.out.println(Nname + "로 변경 완료되었습니다. 재 로그인 부탁드립니다");	
					Session.setData("loginManager", null);
				}else {
					System.out.println("직책 변경 실패입니다.");
				}
			}else if(Nchoice == 1) {
			}else {
				System.out.println("잘못입력하셨습니다.");
			}	
		}else if(choice == 5) {
			// 사단 변경
			System.out.println("변경할 사단 숫자 입력 : ");
			String Nbelong = sc.next();
			System.out.println("변경할 사단이 "+Nbelong+"사단 맞습니까?\n맞으면 숫자\"0\" 틀리면 숫자\"1\"을 입력하세요"); // 재확인작업
			int Bchoice = sc.nextInt();
			if(Bchoice == 0) {
				if(mdao.modifyBelong(Nbelong, loginManager.MarmyCode)) {
					System.out.println(Nbelong + "사단으로 변경 완료되었습니다. 재 로그인 부탁드립니다");	
					Session.setData("loginManager", null);
				}else {
					System.out.println("사단 변경 실패입니다.");
				}
			}else if(Bchoice == 1) {
			}else {
				System.out.println("잘못입력하셨습니다.");
			}	
		}
		
		
		
		
		
		
	}
}
