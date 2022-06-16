package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.CarDAO;
import dto.CarDTO;

public class CarListView {
	public CarListView() {
		Scanner sc = new Scanner(System.in);
		CarDAO cdao = new CarDAO();
		if(!cdao.checkCar()) {			// 등록된 차량이 있는지 부터 확인 없으면 아래
			System.out.println("현재는 차량이 없습니다.");
		}else { 						// 있으면 여기
			System.out.println("검색할 차량 번호 : ");
			String carnum = sc.next();
			ArrayList<CarDTO> result = cdao.getList();
			CarDTO c = new CarDTO();
			if(result.size() == 0) {
				System.out.println("해당 차량이 없습니다.");
			}else {
				if(cdao.checkCaruse(carnum)) { // 상태가 true인 차량을 검색 후 있으면 true리턴, 즉 사용가능
					System.out.println(carnum+"의 차량은 현재 이용 가능합니다.");				
				}else { // 상태가 true인차량이 없으므로 false리턴, 즉 사용불가(이미사용중)
					System.out.println(carnum+"의 차량은 현재 이용 불가입니다.");
				}
			}
		}
	}
}
