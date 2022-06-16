package dto;

public class GunDTO {
	public int gunnum;
	public String gunname;
	public String Marmycode;
	
	public GunDTO() {}
	
	public GunDTO(int gunnum, String gunname) {
		this.gunnum = gunnum;
		this.gunname = gunname;
	}

	public GunDTO(int gunnum, String gunname, String solid) {
		this.gunnum = gunnum;
		this.gunname = gunname;
		this.Marmycode = Marmycode;
	}
}
