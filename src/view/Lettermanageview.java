package view;

import java.util.Scanner;

public class Lettermanageview {
	public Lettermanageview() {
		System.out.println("------마음의 편지 관리 페이지------");
		Scanner sc = new Scanner(System.in);
		boolean a = true;
		while(a) {
			System.out.println("1. 편지조회\n2. 편지삭제\n3. 뒤로가기");
			int choice = sc.nextInt();
			
		switch(choice) {
		case 1:
		{
			new Letters_inquiryview();
			break;
		}
		case 2:
		{
			new Letters_deleteview();
			break;
		}
		case 3:
		{
			a = false;
		}
		}
		
		}
	}
}
