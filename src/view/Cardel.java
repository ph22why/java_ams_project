package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.CarDAO;
import dao.Session;
import dao.TransDAO;
import dto.CarDTO;

public class Cardel {
	public Cardel() {
		while(true) { // 차량이 폐차되면 나가지도록 설정
			CarDTO c = (CarDTO)Session.getData("c");
			if(c == null) {
				break;
			}
		}
		TransDAO tdao = new TransDAO();
		CarDAO cdao = new CarDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("폐차시킬 차량번호를 입력하십시오 : ");
		String carnum = sc.next();
		int gbnum = 4;
		int amount = 1;
		String gbname = carnum;
		if(tdao.send(gbnum, gbname, amount)) {
			if(cdao.cardel(carnum)) {
				System.out.println(carnum+"의 차량이 삭제되었습니다!");
				while(true) {
					int num = tdao.checknum();
					if(num >= 30) {
						if(tdao.empty()) {
							System.out.println("폐기물 처리 완료되었습니다.");		
							break;
						}else {
							break;
						}
					}break;
				}
			}else {
				System.out.println("행삭제실패");
			}
		}else {
			System.out.println("총기 반납 실패 / 다음에 다시 반납해 주세요.");
		}
	}
}
