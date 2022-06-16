package view;

import java.util.Scanner;

import dao.Session;
import dto.ConsultantDTO;


public class ConsultantMainview {
	public ConsultantMainview() {
		System.out.println("------상담가용 페이지 입니다.------");
		Scanner sc = new Scanner(System.in);
		while(true) {
			
			ConsultantDTO Consultantuser = (ConsultantDTO)Session.getData("Consultantuser");
			if(Consultantuser == null) {
				System.out.println("로그인 후 이용해 주세요.");
				break;
			}
			System.out.println("1. 병사 목록 조회\n2. 마음의 편지 관리\n3. 로그아웃");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:{
				new Soldierinforview2();
				break;
			}
			case 2:{
				new Lettermanageview();
				break;
			}
			case 3:{
				System.out.println(Consultantuser.name+"상담사님 로그아웃 되었습다.");
				Session.setData("Consultantuser", null);
				break;
				
			}
			
			}
		}
	}
}
