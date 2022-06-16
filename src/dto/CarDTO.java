package dto;

public class CarDTO {
	public String carnum;
	public String carname;
	public boolean caruse;
	
	public CarDTO() {}
	
	public CarDTO(String carnum, String carname, boolean caruse) {
		this.carnum = carnum;
		this.carname = carname;
		this.caruse = caruse;
	}
}