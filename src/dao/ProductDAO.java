package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.ManagerDTO;
import dto.ProductDTO;

public class ProductDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public ProductDAO() {
		conn = DBConnection.getConnection();
	}

	public boolean addProduct(ProductDTO newProduct) {
		ArrayList<ProductDTO> result = new ArrayList<ProductDTO>();
		String sql = "insert into product (prodname,prodamount) values(?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, newProduct.prodname);
			ps.setInt(2, newProduct.prodamount);
			
//			while(rs.next()) {
//				ProductDTO p = new ProductDTO();
//				p.prodnum = rs.getInt("prodnum");
//				p.prodname = rs.getString("prodname" );
//				p.prodamount = rs.getInt("prodamount" );
//			
//				result.add(p);
//			}
			
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
		}return false;
	}

	public ArrayList<ProductDTO> getList() {
		String userid = ((ManagerDTO)Session.getData("loginManager")).MarmyCode;
		ArrayList<ProductDTO> result = new ArrayList<ProductDTO>();
		String sql = "select * from product";

		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ProductDTO p = new ProductDTO();
				p.prodnum = rs.getInt("prodnum");
				p.prodname = rs.getString("prodname");
				p.prodamount = rs.getInt("prodamount");			
				result.add(p);
			}
		} catch (SQLException e) {
		}
		
		
		return result;
	}
	
	public boolean updateProd(String prodname, int newamount) {
		try {
			String sql = "update product set prodamount = (prodamount - ?) where prodname = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, newamount);
			ps.setString(2, prodname);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
		}return false;
	}

	public int checkprodamount(String prodname) {
		try {
			String sql = "select prodamount from product where prodname = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, prodname);	
			rs = ps.executeQuery();
			if(rs.next()) {
				int amount = rs.getInt(1);
				return amount;
			}
		}catch(SQLException e) {
		}return 0;
	}
	
	public boolean removeProduct(String prodname) {
		String sql = "delete from product where prodnum = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, prodname);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
		}
		return false;
	}

	public boolean modifyProduct(int prodnum, int choice, String newData) {
		ArrayList<ProductDTO> result = new ArrayList<ProductDTO>();
		//choice : 1 - 가격수정 / 2 - 재고수정
		String sql = "";
		String[] cols = {"","prodname","prodamount"};
		try {
			switch(choice) {
			case 1:
				sql = "update product set "+cols[choice]+" = ? where prodnum="+prodnum;
				ps = conn.prepareStatement(sql);
				ps.setString(1, newData);
				break;
			case 2:
				sql = "update product set prodamount = ? where prodnum = " + prodnum;
				ps = conn.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(newData));
				break;
			}
			while(rs.next()) {
				ProductDTO p = new ProductDTO();
				p.prodnum = rs.getInt("prodnum");
				p.prodname = rs.getString("prodname" );
				p.prodamount = rs.getInt("prodamount" );
			
				result.add(p);
			}
			return ps.executeUpdate() == 1;
		} catch (NumberFormatException e) {
		} catch (SQLException e) {
		}
		return false;
	}

	public ArrayList<ProductDTO> search(String keyword) {
		ArrayList<ProductDTO> result = new ArrayList<ProductDTO>();
		String sql = "select * from product where prodname like ('%"+keyword+"%')";
		try {
			ps = conn.prepareStatement(sql);		
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductDTO p = new ProductDTO();
				p.prodnum = rs.getInt("prodnum");
				p.prodname = rs.getString("prodname");
				p.prodamount = rs.getInt("prodamount");
				result.add(p);
			}
		} catch (SQLException e) {
		}
		
		return result;
	}
	
}










