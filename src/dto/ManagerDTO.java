package dto;

public class ManagerDTO {
	public String MarmyCode;
	public String Mpassword;
	public String Mgrade;
	public String Mjob;
	public String Mname;
	public String Mbirth;
	public int Mgunnum;
	public int basenum;
	
	public ManagerDTO() {}
	// 2. 받은 매개변수값들을 위의 전역변수에 넣어준다
	public ManagerDTO(String MarmyCode, String Mpassword, String Mgrade, String Mjob, String Mname, String Mbirth,
			int Mgunnum, int basenum) {
		this.MarmyCode = MarmyCode;
		this.Mpassword = Mpassword;
		this.Mgrade = Mgrade;
		this.Mjob = Mjob;
		this.Mname = Mname;
		this.Mbirth = Mbirth;
		this.Mgunnum = Mgunnum;
		this.basenum = basenum;
	}
	
	
}
