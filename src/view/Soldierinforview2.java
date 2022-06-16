package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.SoldierDAO;
import dto.SoldierDTO;

public class Soldierinforview2 {
	public Soldierinforview2() {
		System.out.println("------상담가용 병사 정보 페이지입니다.------");
		SoldierDAO Soldierdao = new SoldierDAO();
		SoldierDTO Soliderdto = new SoldierDTO();
		Scanner sc = new Scanner(System.in);
		System.out.println("병사 군번 :");
		String sarmycode = sc.next();
		
		ArrayList<SoldierDTO> result = Soldierdao.search2(sarmycode);
		if(result.size()==0) {
			System.out.printf("없는 병사 군번입니다. 다시 시도해 주세요");
		}
		else {
			for(SoldierDTO s : result) {
			
				System.out.printf("병사군번:%s\n병사계급:%s\n병사이름:%s\n병사소속:%s\n",
						s.sarmycode,s.sgrade,s.sname,s.scamp);
			}
		}
		
	}
}
