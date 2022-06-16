package view;

import java.util.Scanner;

import com.mysql.cj.Session;

import dao.GunDAO;
import dto.GunDTO;
import dto.ManagerDTO;

public class AddGunView {
	public AddGunView() {
		//총기번호, 총기명, 총기설명(나중에 데이터베이스 총기종류를 따로 추가한다음 총기코드 별로 정렬 재고 확인할 수 있게하기)
		GunDAO gdao = new GunDAO();
		Scanner sc = new Scanner(System.in);
		System.out.print("총기번호 : ");
		int gunnum = sc.nextInt();
		System.out.print("총기명 : ");
		sc = new Scanner(System.in);
		String gunname = sc.nextLine();
		
		ManagerDTO loginManager = (ManagerDTO)dao.Session.getData("loginManager");
		
		GunDTO newGun = new GunDTO(gunnum, gunname, loginManager.MarmyCode);
		
		if(gdao.addGun(newGun)) {
			System.out.println(gunname+" 등록완료!");
		}
		else {
			System.out.println("총기 등록 실패 / 다음에 다시 시도해 주세요.");
		}
		
	}
}
