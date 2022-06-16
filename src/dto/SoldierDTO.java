package dto;

public class SoldierDTO {
	public String sarmycode;
	public String sgrade;
	public String sname;
	public String sbirth;
	public String sstate;
	public int gunnum;
	public int scamp;
	public String pw;
	
	public SoldierDTO() {}

	public SoldierDTO(String sarmycode, String sgrade, String sname, String sbirth, String sstate, int gunnum, int scamp) {
		this.sarmycode = sarmycode;
		this.sgrade = sgrade;
		this.sname = sname;
		this.sbirth = sbirth;
		this.sstate = sstate;
		this.gunnum = gunnum;
		this.scamp = scamp;
	}
	
	public SoldierDTO(String sarmycode,String pw) {
		this.sarmycode = sarmycode;
		this.pw = pw;
	}
}
