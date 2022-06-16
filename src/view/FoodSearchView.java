package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.FoodDAO;
import dto.FoodDTO;

public class FoodSearchView {
	public FoodSearchView() {
		FoodDAO fdao = new FoodDAO();
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 식품명을 입력하세요 : ");
		String keyword = sc.nextLine();
		
		ArrayList<FoodDTO> result = fdao.search(keyword);

		System.out.println("\""+keyword+"\" 로 검색된 결과");
		if(result.size() == 0) {
			System.out.println("검색된 결과가 없습니다.");
		}
		else {
			for (FoodDTO f : result) {
				System.out.printf("%s(%d개) - 유통기한 : %s\n",f.foodname,f.foodamount,f.foodexpdate);
			}
		}
		System.out.println("---------------------------------------");
		System.out.print("검색 할 식품명 입력(0번을 누르면 종료됩니다.) : ");
		String foodname = sc.next();
		if(foodname != null) {
			new FoodInfoView(foodname);
		}
	}
}
