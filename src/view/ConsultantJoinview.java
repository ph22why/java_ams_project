package view;

import java.util.Scanner;

import dao.ConsultantDAO;
import dto.ConsultantDTO;

public class ConsultantJoinview {
	public ConsultantJoinview() {
		System.out.println("------상담가 회원가입 페이지------");
		Scanner sc = new Scanner(System.in);
		// 상담가를 호출하면 디비 연동
		ConsultantDAO Consultantdao = new ConsultantDAO();
		System.out.print("아이디 : ");
		String id = sc.next();
		if(Consultantdao.checkid(id)) {
			System.out.print("비번 : ");
			String pw = sc.next();
			System.out.print("이름 : ");
			String name = sc.next();
			System.out.print("생년월일 : ");
			String birdate = sc.next();
			sc = new Scanner(System.in);	// 개행문자(엔터)가 버퍼에 저장되어 있기 때문에 
			// 그 엔터가 다음 입력으로 들어가지 않게 초기화를 해줘야 한다.
			System.out.print("주소 : ");		
			String addr = sc.nextLine();
			
			// 사용자의 정보를 newConsultant라는 이름으로 객체를 넘겨준다.
			// DTO로 포장 하기 위해서 
			ConsultantDTO newConsultant = new ConsultantDTO(id,pw,name,birdate,addr);
			//입력 받은거를 포장해서 join에 보냄
			if(Consultantdao.join(newConsultant)) {
				System.out.println("회원가입에 성공하였습니다. ");
			}
			else {
				System.out.println("회원가입 실패했습니다. 다시 시도해 주세요.");
			}
			
		}
		
		else {
			System.out.println("이미 가입된 상담가 입니다.다시 한번 확인 부탁드립니다.");
		}
		
		
		
	}
}
