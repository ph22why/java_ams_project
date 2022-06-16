package dto;

public class LetterDTO {

	public String letter_title;
	public String letter_content;
	public String soldier_milinum;
	public int letternum;
	
	public LetterDTO() {}
	
	public LetterDTO(String soldier_milinum,String letter_title,String letter_content) {
		this.soldier_milinum = soldier_milinum;
		this.letter_title = letter_title;
		this.letter_content= letter_content;
		
	}
	
	public LetterDTO(int letternum,String soldier_milinum,String letter_title,String letter_content) {
		this.letternum = letternum;
		this.soldier_milinum = soldier_milinum;
		this.letter_title = letter_title;
		this.letter_content= letter_content;
		
	}
	
}
