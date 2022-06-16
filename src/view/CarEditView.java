package view;

import java.util.Scanner;

import dao.CarDAO;
import dao.Session;
import dto.CarDTO;

public class CarEditView {
	public CarEditView() {
		Scanner sc = new Scanner(System.in);
		CarDAO cdao = new CarDAO();
		CarDTO c = (CarDTO)Session.getData("c");
		
		System.out.println("====차량 정보 수정 페이지====");
		System.out.println("해당 번호 입력\n1. 사용\n2. 반납\n3. 나가기");
		int choice = sc.nextInt();
		if(choice == 1) {
			// 사용
			System.out.print("사용할 차량번호 입력 부탁드립니다 : ");
			String carnum = sc.next();
			if(cdao.checkCaruse(carnum)) { // 차량 상태가 true인지 확인, true면 사용가능하기때문에
				boolean caruse = false;	// false로 바꿔주고 사용가능메세지 출력
				if(cdao.modifyCaruse(caruse, carnum)) {
					System.out.println("지금부터 차량 사용이 가능합니다. 이용후 반납 부탁드리겠습니다.");
				}	
			}else { // 상태가 true인지확인, false이기때문에 사용불가 메세지 출력
				System.out.println("차량이 대여중입니다.");
			}
		}else if(choice == 2) {
			// 반납
			System.out.print("반납할 차량번호 입력 부탁드립니다 : ");
			String carnum = sc.next();
			if(!cdao.checkCaruse(carnum)) {	// 차량상태가 true인지 확인, false면 !로 true로 바꿔준 후 if 문 진입
				boolean caruse = true;		// 차량상태 true로 바꿔준 후 차량반납 성공 메세지 출력
				if(cdao.modifyCaruse(caruse, carnum)) {
					System.out.println("차량반납이 완료되었습니다.");
				}
			}else { // 차량 상태가 true이기 때문에 아직 대여 전이므로 메세지 출력
				System.out.println("차량대여가 이루어지지않았습니다.");
			}
		}else if(choice == 3){
			System.out.println("메인으로 돌아갑니다.");
		}else {
			System.out.println("잘못된 입력입니다.");
		}
	}
}
