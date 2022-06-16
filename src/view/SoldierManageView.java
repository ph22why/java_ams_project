package view;

import java.util.Scanner;

import dao.Session;
import dao.SoldierDAO;
import dto.SoldierDTO;

public class SoldierManageView {
	public SoldierManageView() {
		SoldierDAO sdao = new SoldierDAO();
		SoldierDTO soldier = (SoldierDTO)Session.getData("soldier");
		Scanner sc = new Scanner(System.in);
		System.out.println("====병사관리 페이지입니다====");
		System.out.println("관리하려는 정보의 숫자 입력 : ");
		System.out.println("1. 병사입대\n2. 병사 목록\n3. 병사 정보 수정\n4. 병사 전역\n5. 나가기");
		int choice = sc.nextInt();
		if(choice == 5) {
			// 나가기
			System.out.println("메인으로 돌아갑니다.");
		}else if(choice == 1) {
			// 병사 입대
			new AddSoldierView();
		}else if(choice == 2) {
			// 병사 목록
			new SoldierListView();
		}else if(choice == 3) {
			// 병사 정보 수정
			new ModifySoldierView();
		}else if(choice == 4) {
			// 병사 전역
			new DeleteSoldierView();
		}else {
			System.out.println("잘못입력하셨습니다.");
		}
	}	
}