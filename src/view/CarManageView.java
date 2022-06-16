package view;

import java.util.Scanner;

import dao.CarDAO;
import dao.Session;
import dto.CarDTO;

public class CarManageView {
	public CarManageView(){
		// caruse : true -> 사용가능
		// caruse : false -> 사용불가(사용중)
		boolean a = true;
//		CarDAO cdao = new CarDAO();
//		CarDTO c = (CarDTO)Session.getData("c");
		Scanner sc = new Scanner(System.in);
		System.out.println("====차량관리 페이지입니다====");
		while(a) {
			System.out.println("1. 신규차량 등록\n2. 차량 조회\n3. 차량 정보 수정\n4. 차량 폐기\n5. 나가기");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				// 신규차량 등록
				new AddCarView();
				break;
			case 2:
				// 차량 조회
				new CarListView();
				break;
			case 3:
				// 차량 정보 수정
				new CarEditView();
				break;
			case 4:
				// 차량 폐기
				new Cardel();
				break;
			case 5:
				a = false;
			}	
		}
	}
}
