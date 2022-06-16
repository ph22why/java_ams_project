package view;

import java.util.Scanner;

import dao.SoldierDAO;
import dto.SoldierDTO;

public class SoldierJoinview {
	public SoldierJoinview() {
		System.out.println("------병사 마편 비번 만들기 페이지------");
		SoldierDAO Soldierdao = new SoldierDAO();
		Scanner sc = new Scanner(System.in);
		System.out.printf("군번 : ");
		String sarmycode = sc.next();
		if(Soldierdao.inspect(sarmycode)) {
		System.out.println("비번 : ");
		String pw = sc.next();
		
		SoldierDTO Soldierdto = new SoldierDTO(sarmycode,pw);
		if(Soldierdao.Join(Soldierdto)) {
			System.out.println("회원가입에 성공하였습니다.");
		}
		else{
			System.out.println("병사의  가입이 실패했습니다.");
		}
		}
		
		else {
			System.out.println("이미 가입된 병사입니다.");
		}
	}
}
