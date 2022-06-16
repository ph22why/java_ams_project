package view;

import java.util.Scanner;

public class JoinView {
	public JoinView() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.간부\n2.상담가");
		int firstChoice = sc.nextInt();
		if(firstChoice == 1) {
			// 간부 회원가입
			new MJoinView();
			
		}else if(firstChoice == 2) {
			// 상담사 회원가입
			new ConsultantJoinview();
		}
	}
}
