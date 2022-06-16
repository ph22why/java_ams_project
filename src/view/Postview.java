package view;

import java.util.Scanner;

import dao.LetterDAO;
import dao.SoldierDAO;
import dto.LetterDTO;

public class Postview {
	public Postview() {
		System.out.println("------마음의 편지 쓰기 페이지------");
		LetterDAO Letterdao = new LetterDAO();
		SoldierDAO Soldierdao = new SoldierDAO();
		Scanner sc = new Scanner(System.in);
		boolean a = true;
		while(a) {
			
			System.out.println("군번 :");
			String milinum = sc.next();
			System.out.println("비번 : ");
			String pw = sc.next();
			
			if(Soldierdao.certification(milinum,pw)) {
				
				while(true) {
					sc = new Scanner(System.in);
					System.out.printf("title : ");
					String letter_title = sc.nextLine(); 
					System.out.printf("content : ");
					String letter_content = sc.nextLine();
					
					if(letter_content.length() <= 200) {
						
						LetterDTO letter = new LetterDTO(milinum,letter_title,letter_content);
						
						if(Letterdao.post(letter)) {
							System.out.println("올리기 성공!");
							a=false;
							break;
						}
						
						else {
							System.out.println("올리기 실패!");
						}
					}
					else {
						System.out.println("글자수가 200자 이상입니다.글자수를 줄여주세요.");
						continue;
					}
			}
					
				}
			else {
				System.out.println("군번또는 비번이 틀렸습니다. 확인바랍니다.");
			}
		}
		
	}

}
