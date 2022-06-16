package view;

import java.util.Scanner;

import dao.ConsultantDAO;
import dao.Session;
import dto.ConsultantDTO;

public class ConsultantLoginview {
	ConsultantLoginview() {
		System.out.println("------상담가용로그인------");
		ConsultantDAO Consultantdao = new ConsultantDAO();
		Scanner sc = new Scanner(System.in);
		System.out.printf("아이디 :");
		String id = sc.next();
		System.out.printf("비번 : ");
		String pw = sc.next();
		
		if(Consultantdao.login(id,pw)) {
			String Consultantname = ((ConsultantDTO)Session.getData("Consultantuser")).name;
			System.out.println(Consultantname+"님 어서오세요~");
			new ConsultantMainview();
			
		}
		else {
			System.out.println("로그인 실패 / 아이디 혹은 비밀번호를 확인해주세요.");
		}
	}
}
