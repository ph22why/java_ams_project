package view;

import java.util.Scanner;

import dao.Session;
import dto.ManagerDTO;

public class MainView {
	public MainView() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			ManagerDTO loginManager = (ManagerDTO)Session.getData("loginManager");
			if(loginManager == null) {
				System.out.println("로그인 후 이용 부탁드립니다.");
				break;
			}
			System.out.println("----간부 메인화면----");
			System.out.println("1. 개인정보 보기");
			System.out.println("2. 개인정보 수정");
			System.out.println("3. 병사 관리");
			System.out.println("4. 종합 관리");
			System.out.println("5. 로그아웃");
			int choice = sc.nextInt();
			
			if(choice == 5) {
				System.out.println(loginManager.Mname + "님 다시오십시오 충성!");
				Session.setData("loginManager", null);
				break;
			}else if(choice == 1) {
				// 개인정보 보기
				new MyInfoView();
			}else if(choice == 2) {
				// 개인정보 수정
				new MyInfoEdit();
			}else if(choice == 3) {
				// 병사 관리
				new SoldierManageView();
			}else if(choice == 4) {
				// 종합 관리
				System.out.println("관리할 항목번호를 선택바랍니다");
				System.out.println("1. 물자관리\n2. 식품관리\n3. 총기관리\n4. 차량관리\n5. 물자이동");
				int Mchoice = sc.nextInt();
				if(Mchoice == 4) {
					new CarManageView();
				}else if(Mchoice == 3) {
					new GunView();
				}else if(Mchoice == 2) {
					new FoodMainView();
				}else if(Mchoice == 1) {
					new ProductMainView();
				}else if(Mchoice == 5) {
					//물자이동
					new TransView();
				}
			}else {
				System.out.println("다시 입력 바랍니다.");
			}
			
		}
	}
}
