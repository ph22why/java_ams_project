package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.LetterDAO;
import dto.LetterDTO;

public class Letters_deleteview {
	public Letters_deleteview() {
		System.out.println("------마음의 편지 삭제 페이지------");
		Scanner sc = new Scanner(System.in);
		LetterDAO Letterdao = new LetterDAO();
		LetterDTO Letterdto = new LetterDTO();
		ArrayList<LetterDTO> result = Letterdao.search();
		if(result.size()==0) {
			System.out.println("편지 목록이 없습니다.");
		}
		
		else {
			for(LetterDTO l : result) {
				System.out.printf("%d번째 마편\nmilinum: %s\ntitle : %s\ncontent: %s\n",l.letternum,l.soldier_milinum
						,l.letter_title,l.letter_content);
			}
		}
		
		System.out.println("몇번째 편지를 삭제하시겠습니까?");
		int choice = sc.nextInt();
		
		if(Letterdao.delete(choice)) {
			System.out.println("삭제 완료 했습니다.");
		}
		
		else {
			System.out.println("삭제 실패 했습니다.");
		}
	}
}
