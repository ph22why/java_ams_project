package view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import dao.ProductDAO;
import dao.Session;
import dao.TransDAO;
import dto.ManagerDTO;
import dto.ProductDTO;

public class ProductMainView {
	public ProductMainView() {
		boolean a = true;
		ProductDAO pdao = new ProductDAO();
		TransDAO tdao = new TransDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("------물자 관리------");
		while(a) {
			ManagerDTO loginManager = (ManagerDTO)Session.getData("loginManager");
			if(loginManager == null) {
				System.out.println("로그인 후 이용하세요");
				break;
			}
 			System.out.println("1. 물자 추가");
			System.out.println("2. 물자 정보 수정");
			System.out.println("3. 물자 정보 삭제");
			System.out.println("4. 물자 상태 보기");
			System.out.println("5. 물자 검색");
			System.out.println("6. 뒤로가기");		
			int choice = sc.nextInt();

			ArrayList<ProductDTO> result = null;
			int prodnum = 0;
			switch(choice) {
			case 1:
				//물자 추가
				new AddProductView();
				break;
			case 2:
				//물자 정보 수정(재고, 수량)
				new ModifyProductView();
				break;
			case 3:
				//물자 정보 삭제
				result = pdao.getList();
				System.out.println("==========물자 목록==========");
				if(result.size() == 0) {
					System.out.println("등록한 물자가 없습니다.");
				}
				for (ProductDTO p : result) {
					System.out.printf("%d. %s - (재고 : %d개)\n",p.prodnum,p.prodname,p.prodamount);
				}
				System.out.println("==================================");
				System.out.print("삭제할 물자 이름 : ");
				String prodname = sc.next();
				System.out.print("삭제할 물자의 개수를 입력하세요 : "); 
				int amount = sc.nextInt();
				int gbnum = 1;
				String gbname = prodname;
				int dbamount = pdao.checkprodamount(prodname);
				if(tdao.send(gbnum, gbname, amount)) {
					if(dbamount <= amount) {
						if(pdao.removeProduct(prodname)) {
							System.out.println(prodname+"이(가) 삭제되었습니다!");
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
						if(pdao.updateProd(prodname, amount)) {
							System.out.println(prodname+"이(가) "+amount+"개 삭제되었습니다." );
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
					System.out.println("정보 삭제 오류 / 다음에 다시 시도해 주세요.");
				}
				break;
			case 4:
				//물자 보기
				result = pdao.getList();
				System.out.println("==========물자 목록==========");
				if(result.size() == 0) {
					System.out.println("등록한 물자가 없습니다.");
				}
				for (ProductDTO p : result) {
					System.out.printf("%d. %s - (재고 : %d개)\n",p.prodnum,p.prodname,p.prodamount);
				}
				System.out.println("==================================");
				break;
			case 5:
				//물자 검색 - 미구현(향후 추가할 예정)
				new ProductSearchView();
				break;
			case 6:
				a = false;
			}
		}
	}
}





