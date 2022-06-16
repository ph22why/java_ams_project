package view;

import java.util.Scanner;

public class Letterview {
	public Letterview() {
		System.out.println("------마음의 편지 페이지------");
		Scanner sc = new Scanner(System.in);
		boolean a = true;
		while(a) {
			
			System.out.println("1. 마편비번만들기(병사)\n2. 편지쓰기\n3.뒤로가기");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:{
				new SoldierJoinview();
				a= false;
				break;
			}
			case 2: {
				
				new Postview();
				a = false;
				break;
			}
			case 3: {
				 a= false;
			}
			
			}
		}
		
	}

}
