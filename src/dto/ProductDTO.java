package dto;

public class ProductDTO {
	public int prodnum;
	public String prodname;
	public int prodamount;
	
	public ProductDTO() {}
	
	public ProductDTO(int prodnum, String prodname, int prodamount) {
		this.prodnum = prodnum;
		this.prodname = prodname;
		this.prodamount = prodamount;
	}
	
	public ProductDTO(String prodname, int prodamount) {
		this.prodname = prodname;
		this.prodamount = prodamount;
	}

	@Override
	public String toString() {
		return prodnum+"\t"+prodname+"\t"+"\t"+prodamount+"\t";
	}
}








