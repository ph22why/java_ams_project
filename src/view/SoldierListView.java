package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.SoldierDAO;
import dto.SoldierDTO;

public class SoldierListView {
	public SoldierListView() {
		Scanner sc = new Scanner(System.in);
		SoldierDAO sdao = new SoldierDAO();
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
	}
}
