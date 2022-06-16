package view;

import dao.TransDAO;

public class TransView {
	public TransView() {
		TransDAO tdao = new TransDAO();
		System.out.println("현재 폐기물 개수 : " + tdao.checknum());
	}
}
