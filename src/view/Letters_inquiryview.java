package view;

import java.util.ArrayList;

import dao.LetterDAO;
import dto.LetterDTO;

public class Letters_inquiryview {
	public Letters_inquiryview() {
		System.out.println("------마음의 편지 조회 페이지------");
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
	}
}
