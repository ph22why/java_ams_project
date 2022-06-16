package view;

import java.util.Scanner;

import dao.ProductDAO;
import dao.Session;
import dto.ManagerDTO;
import dto.ProductDTO;

public class AddProductView {
	public AddProductView() {
		//상품명, 상품가격, 상품재고, 상품설명	/  상품번호, 판매자, 좋아요개수
		ProductDAO pdao = new ProductDAO();
		Scanner sc = new Scanner(System.in);
		System.out.print("물자 이름 : ");
		String prodname = sc.next();
		System.out.print("물자 재고 : ");
		int prodamount = sc.nextInt();
		
		ManagerDTO loginManager = (ManagerDTO)Session.getData("loginManager");
		
		ProductDTO newProduct = new ProductDTO(prodname, prodamount);
		
		if(pdao.addProduct(newProduct)) {
			System.out.println(prodname+" 물자 추가 완료!");
		}
		else {
			System.out.println("물자 추가 실패 / 다음에 다시 시도해 주세요.");
		}
		
	}
}









