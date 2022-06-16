package view;

import java.util.Scanner;

import dao.BaseDAO;
import dao.GunDAO;
import dao.SoldierDAO;
import dto.GunDTO;
import dto.SoldierDTO;

public class AddSoldierView {
	public AddSoldierView() {
		GunDAO gdao = new GunDAO();
		SoldierDAO sdao = new SoldierDAO();
		BaseDAO bdao = new BaseDAO();
		Scanner sc = new Scanner(System.in);
		System.out.print("병사 군번 : ");
		String sarmycode = sc.next();
		System.out.print("병사 계급 : ");
		String sgrade = sc.next();
		System.out.print("병사 이름 : ");
		String sname = sc.next();
		System.out.print("병사 생년월일(6자리) : ");
		String sbirth = sc.next();
		System.out.print("병사 상태 : ");
		String sstate = sc.next();
		System.out.print("병사 총기명 : ");
		String gunname = sc.next();
		System.out.print("병사 총기번호 : ");
		int gunnum = sc.nextInt();
		if(gdao.checkgnum(gunnum)) {
			System.out.print("병사 소속 사단 : ");
			sc = new Scanner(System.in);
			int scamp = sc.nextInt();
			if(bdao.checkbnum(scamp)) {
				SoldierDTO newSoldier = new SoldierDTO(sarmycode, sgrade, sname, sbirth, sstate, gunnum, scamp);
				GunDTO newGun = new GunDTO(gunnum, gunname);
				if(gdao.gjoin(newGun)) {
					if(sdao.addSoldier(newSoldier)) {
						System.out.println(sarmycode + "/" + sname + " 추가 완료!");
					}else {
						System.out.println("병사 추가 실패 / 다시시도부탁드립니다.");
					}
				}else {	
				}
			}else {	
				System.out.println("잘못된 부대번호 입니다");
			}
		}else {
			System.out.println("중복된 총기번호가 있습니다 / 다시 시도해주세요");
		}
	}
}
