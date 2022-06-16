package dto;

public class FoodDTO {
	public String foodname;
	public int foodamount;
	public String foodexpdate;
	
	public FoodDTO() {}
	
	public FoodDTO(String foodname, int foodamount, String foodexpdate) {
		this.foodname = foodname;
		this.foodamount = foodamount;
		this.foodexpdate = foodexpdate;
	}
	
	@Override
	public String toString() {
		return foodname+"\t"+foodamount+"\t"+foodexpdate;
	}
}

