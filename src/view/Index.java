package view;

import java.util.Scanner;

import dao.DBConnection;


public class Index {
	public static void main(String[] args) {
		System.out.println("군 통합 시스템");
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. 회원가입\n2. 로그인\n3. 마음의편지\n4. 나가기");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				// 회원가입
				new JoinView();
			}else if(choice == 2) {
				// 로그인
				new LoginView();
			}else if(choice == 3) {
				// 마음의편지
				new Letterview();
			}else if(choice == 4){
				System.out.println("다음에 뵙겠습니다 충성!");
				break;
			}else {
				System.out.println("다시 입력해주십시오");
			}
		}
	}
}
