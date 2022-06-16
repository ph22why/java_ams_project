package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.GunDAO;
import dao.SoldierDAO;
import dto.SoldierDTO;

public class DeleteSoldierView {
	public DeleteSoldierView() {
		SoldierDAO sdao = new SoldierDAO();
		GunDAO gdao = new GunDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("전역시킬 병사의 사단번호를 입력하십시오 : ");
		int scamp = sc.nextInt();
		ArrayList<SoldierDTO> result = sdao.getList(scamp);
		if(result.size() == 0) {
			System.out.println("남은 병사가 없습니다.");
		}
		for(SoldierDTO s : result) {
			System.out.printf("%s - %s - %s\n", s.sarmycode, s.sgrade, s.sname);
		}
		System.out.println("==================================");
		System.out.print("전역시킬 병사의 군번 : ");
		String sac = sc.next();
		int gunnum = sdao.getListG(sac);
		if(gdao.removeGun(gunnum)) {
			if(sdao.removeSoldier(sac)) {
				System.out.println(sac+"번의 군인 전역이 완료되었습니다");				
			}
		}else {
			System.out.println("전역 실패 / 다시시도하십시오.");
		}
	}
}
