package view;

import java.util.Scanner;

import dao.CarDAO;
import dto.CarDTO;

public class AddCarView {
	public AddCarView() {
		CarDAO cdao = new CarDAO();
		Scanner sc = new Scanner(System.in);
		System.out.print("차량 번호 : ");
		String carnum = sc.next();		
		System.out.print("차량 이름 : ");
		String carname = sc.next();
		boolean caruse = true; // 바로 사용가능하도록 true로 넣어놨음
		
		CarDTO c = new CarDTO(carnum, carname, caruse);
		
		if(cdao.addCar(c)) {
			System.out.println(carnum + "의 "+carname+"차 추가완료!");
		}else {
			System.out.println("차량 등록 실패 / 다시 시도 부탁드립니다.");
		}
	}
}
