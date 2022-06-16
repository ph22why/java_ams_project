package view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import dao.FoodDAO;
import dao.Session;
import dao.TransDAO;
import dto.FoodDTO;
import dto.ManagerDTO;

public class FoodMainView {
	public FoodMainView() {
		FoodDAO fdao = new FoodDAO();
		FoodDTO fdto = new FoodDTO();
		TransDAO tdao = new TransDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("------메인화면------");
		while(true) {
			ManagerDTO loginManager = (ManagerDTO)Session.getData("loginManager");
			if(loginManager == null) {
				System.out.println("로그인 후 이용하세요");
				break;
			}
 			System.out.println("1. 식품추가로 이동");
			System.out.println("2. 식품수정으로 이동");
			System.out.println("3. 식품삭제로 이동");
			System.out.println("4. 등록한 식품 보기");
			System.out.println("5. 등록된 식품 검색");
			System.out.println("6. 뒤로가기");
			int choice = sc.nextInt();
			
			if(choice == 6) {
				break;
			}
			ArrayList<FoodDTO> result = null;
			switch(choice) {
			case 1:
				//식품추가로 이동
				new AddFoodView();
				break;
			case 2:
				//식품수정으로 이동
				new ModifyFoodView();
				break;
			case 3:
				//식품 삭제로 이동
				result = fdao.getList();
				System.out.println("-----등록된 식품목록-----");
				if(result.size() == 0) {
					System.out.println("등록한 식품이 없습니다.");
				}
				for (FoodDTO f : result) {
					System.out.printf("%s : %d개 - %s\n",f.foodname,f.foodamount,f.foodexpdate);
				}
				System.out.println("-------------------------------------");
				System.out.print("삭제할 식품명을 입력하세요. : ");
				String foodname = sc.next();
				System.out.print("삭제할 식품의 개수를 입력하세요 : "); 
				int amount = sc.nextInt();
				int gbnum = 2;
				String gbname = foodname;
				int dbamount = fdao.checkfoodamount(foodname);
				if(tdao.send(gbnum, gbname, amount)) {
					if(dbamount <= amount) {
						if(fdao.removeFood(foodname)) {
							System.out.println(foodname+"이(가) 삭제되었습니다!");
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
					}else if(dbamount > amount) {
						if(fdao.updateFood(foodname, amount)) {
							System.out.println(foodname+"이(가) "+amount+"개 삭제되었습니다." );
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
							System.out.println("업데이트실패");
						}
					}else {
						System.out.println("실패");
					}
				}else {
					System.out.println("식품 삭제 실패.");
				}
				break;
			case 4:
				//등록된 식품 보기
				result = fdao.getList();
				System.out.println("-----등록된 식품목록-----");
				if(result.size() == 0) {
					System.out.println("등록한 식품이 없습니다.");
				}
				for (FoodDTO f : result) {
					System.out.printf("%s : %d개 - %s\n",f.foodname,f.foodamount,f.foodexpdate);
				}
				System.out.println("-------------------------------------");
				break;
			case 5:
				//등록된 식품 검색
				new FoodSearchView();
				break;
				
			}
		}
	}
}


