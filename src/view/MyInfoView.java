package view;

import java.util.Scanner;

import dao.ManagerDao;
import dao.Session;
import dto.ManagerDTO;

public class MyInfoView {
	public MyInfoView() {
		ManagerDao mdao = new ManagerDao();
		Scanner sc = new Scanner(System.in);
		ManagerDTO loginManager = (ManagerDTO)Session.getData("loginManager");
		System.out.println("☆★☆★"+loginManager.Mname+"님의 정보입니다☆★☆★");
		System.out.println("군번 : "+ loginManager.MarmyCode);
		System.out.println("비밀번호 : " + loginManager.Mpassword);
		System.out.println("계급 : "+ loginManager.Mgrade);
		System.out.println("직책 : " + loginManager.Mjob);
		System.out.println("이름 : " + loginManager.Mname);
		System.out.println("생년월일 : " + loginManager.Mbirth);
		System.out.println("총기번호 : " + loginManager.Mgunnum);
		System.out.println("부대 : " + loginManager.basenum + "부대");	
		System.out.println("========================");
		System.out.println("돌아가려면 아무 숫자 입력바랍니다.");
		int choice = sc.nextInt();
		
		if(choice == 0) {
			System.out.println("메인화면으로 돌아갑니다.");
		}else {
			System.out.println("메인화면으로 돌아갑니다.");
		}
	}
}
