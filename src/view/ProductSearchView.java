package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.ProductDAO;
import dto.ProductDTO;

public class ProductSearchView {
	public ProductSearchView() {
		ProductDAO pdao = new ProductDAO();
		//상품명, 상품설명에 포함되어 있으면 검색할 대상
		Scanner sc = new Scanner(System.in);
		//검색어를 입력하세요 www
		System.out.print("검색어를 입력하세요 : ");
		String keyword = sc.nextLine();
		
		ArrayList<ProductDTO> result = pdao.search(keyword);
	
		//"지우개" 로 검색된 결과
		System.out.println("\""+keyword+"\" 로 검색된 결과");
		if(result.size() == 0) {
			System.out.println("검색된 결과가 없습니다.");
		}
		else {
			for (ProductDTO p : result) {
				System.out.printf("%d. %s. %d개\n",p.prodnum,p.prodname,p.prodamount);
			}
		}
		System.out.println("===================================================");
		System.out.print("자세히 볼 물자번호(나가시려면 0번) : ");
		int prodnum = sc.nextInt();
		if(prodnum != 0) {
			new ProductInfoView(prodnum);
		}
	}
}







