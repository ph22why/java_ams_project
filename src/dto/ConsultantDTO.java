package dto;

public class ConsultantDTO {

	public String id;
	public String pw;
	public String name;
	public String birdate;
	public String addr;

	
	// 다른곳에서 호출할려고 기본생성자 생성
	public ConsultantDTO() {}
	
	
	// 사용자에게 입력 받은거를 저장하기 위해서 생성자 생성
	public ConsultantDTO(String id, String pw,String name ,String birdate, String addr) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birdate = birdate;
		this.addr = addr;
	}
	
		
	
	
}