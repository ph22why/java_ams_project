package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.FoodDAO;
import dto.FoodDTO;

public class ModifyFoodView {
	public ModifyFoodView() {
		Scanner sc = new Scanner(System.in);
		FoodDAO fdao = new FoodDAO();
		ArrayList<FoodDTO> result = fdao.getList();
		
		System.out.println("-----식품 정보 수정-----");
		if(result.size() == 0) {
			System.out.println("등록한 상품이 없습니다.");
		}else {
			for (FoodDTO f : result) {
				System.out.printf("%s. %d개. %s\n",f.foodname,f.foodamount,f.foodexpdate);
			}
			System.out.println("==================================");
			System.out.print("수정할 식품명 : ");
			String foodname = sc.next();
			System.out.println("1. 유통기한 수정\n2. 재고 수정");
			int choice = sc.nextInt();
			System.out.print("새로운 수정 내용 : ");
			sc = new Scanner(System.in);
			String newData = sc.nextLine();
			
			if(fdao.modifyFood(foodname,choice,newData)) {
				System.out.println("식품 " + foodname+" 정보 수정 성공!");
			}
			else {
				System.out.println("식품 정보 수정 실패!");
			}			
		}
	}
}

