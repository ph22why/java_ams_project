package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.GunDAO;
import dto.GunDTO;

public class ModifyGunView {
	public ModifyGunView() {
		Scanner sc = new Scanner(System.in);
		GunDAO gdao = new GunDAO();
		ArrayList<GunDTO> result = gdao.getList();

		System.out.print("수정할 총기 번호 : ");
		int gunnum = sc.nextInt();
		System.out.println("1. 총기번호\n2. 총기명");
		int choice = sc.nextInt();
		System.out.print("새로운 정보 : ");
		sc = new Scanner(System.in);
		String newData = sc.nextLine();
		
		if(gdao.modifyGun(gunnum,choice,newData)) {
			System.out.println("총기 수정 성공");
		}
		else {
			System.out.println("총기 수정 실패 / 다음에 다시 시도해 주세요.");
		}
	}
}
