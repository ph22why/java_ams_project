package view;

import java.util.Scanner;

import dao.FoodDAO;
import dao.Session;
import dto.FoodDTO;
import dto.ManagerDTO;

public class AddFoodView {
	public AddFoodView() {
		FoodDAO fdao = new FoodDAO();
		Scanner sc = new Scanner(System.in);
		System.out.print("식품 이름 : ");
		String foodname = sc.nextLine();
		System.out.print("식품 수량 : ");
		int foodamount = sc.nextInt();
		System.out.print("식품 유통기한\n예시 ~~~~년~~월~~일 :");
		String foodexpdate = sc.next();
		
		ManagerDTO loginManager = (ManagerDTO)Session.getData("loginManager");
		
		FoodDTO newFood = new FoodDTO(foodname,foodamount,foodexpdate);
		
		if(fdao.addFood(newFood)) {
			System.out.println(foodname+" 식품 추가가 완료되었습니다.");
		}
		else {
			System.out.println("식품 추가에 실패하였습니다.");
		}
		
	}
}

