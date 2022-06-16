package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.ProductDAO;
import dto.ProductDTO;

public class ModifyProductView {
	public ModifyProductView() {
		Scanner sc = new Scanner(System.in);
		ProductDAO pdao = new ProductDAO();
		ArrayList<ProductDTO> result = pdao.getList();
		
		System.out.println("==========내가 올린  물자 목록==========");
		if(result.size() == 0) {
			System.out.println("등록한 물자가 없습니다.");
		}else {
			for (ProductDTO p : result) {
				System.out.printf("%d. %s. 재고 : %d개\n",p.prodnum,p.prodname,p.prodamount);
			}
			System.out.println("==================================");
			System.out.print("수정할 물자번호 : ");
			int prodnum = sc.nextInt();
			System.out.println("1. 물자이름수정\n2. 재고수정");
			int choice = sc.nextInt();
			System.out.print("새로운 정보 : ");
			sc = new Scanner(System.in);
			String newData = sc.nextLine();
			
			if(pdao.modifyProduct(prodnum,choice,newData)) {
				System.out.println(prodnum+"번 물자 수정 성공!");
			}
			else {
				System.out.println("물자 수정 실패 / 다음에 다시 시도해 주세요.");
			}			
		}
	}
}








